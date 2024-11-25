class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        int ans=Integer.MIN_VALUE;
        int total_sum=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            total_sum+=nums[i];
        }
        //this is when we can find ans in the array without cheking rotated
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            ans=Math.max(ans,sum);
            if(sum<0){
                sum=0;
            }
            
        }
        int min_sum=nums[0];
        int s2=nums[0];
        for(int i=1;i<n;i++){
            min_sum=Math.min(nums[i],min_sum+nums[i]);
            s2=Math.min(s2,min_sum);
        }
        int s1=total_sum-s2;
        if(s1>0){
            ans=Math.max(ans,s1);
        }
        return ans;
        
        
    }
}