class Solution {
    public int maxAscendingSum(int[] nums) {
        int sum=nums[0];
        int ans=sum;
        for(int i=1;i<nums.length;i++){
            if(nums[i]>nums[i-1]){
                sum+=nums[i];
                ans=Math.max(ans,sum);
            }
            else{
                sum=nums[i];
                ans=Math.max(ans,sum);
            }
        }
       
        return ans;
    }
}