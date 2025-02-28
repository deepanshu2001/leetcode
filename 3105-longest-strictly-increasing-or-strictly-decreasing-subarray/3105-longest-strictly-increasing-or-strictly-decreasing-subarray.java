class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int inc=1;
        int dec=1;
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                dec++;
                inc=1;
            }
            else if(nums[i]<nums[i+1]){
                inc++;
                dec=1;
            }
            else{
                dec=1;
                inc=1;
            }
            ans=Math.max(ans,Math.max(inc,dec));
        }
        return ans;
    }
}