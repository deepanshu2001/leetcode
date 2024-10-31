class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int max=nums[i];
            int min=nums[i];
            for(int j=i;j<nums.length;j++){
                max=Math.max(nums[j],max);
                min=Math.min(min,nums[j]);
                if(max-min<=limit){
                    ans=Math.max(ans,j-i+1);
                }
                else{
                    break;
                }
                
            }
        }
        return ans;
    }
}