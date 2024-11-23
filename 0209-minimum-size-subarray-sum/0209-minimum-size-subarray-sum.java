class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i=0;
        int j=0;
        int sum=0;
        int ans=Integer.MAX_VALUE;
        while(j<nums.length){
           sum+=nums[j];
           if(sum>=target){
            ans=Math.min(ans,j-i+1);
            while(sum>=target){
                sum-=nums[i];
                i++;
                if(sum>=target){
                    ans=Math.min(ans,j-i+1);
                }
                else{
                    i=j+1;
                    sum=0;
                }
            }
           }
           j++;
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}