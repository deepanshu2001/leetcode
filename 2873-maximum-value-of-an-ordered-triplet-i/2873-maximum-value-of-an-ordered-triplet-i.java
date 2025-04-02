class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans=0;
        long imax=0;
        long diff_max=0;
        for(int k=0;k<nums.length;k++){
            ans=Math.max(ans,diff_max*nums[k]);
            diff_max=Math.max(diff_max,imax-nums[k]);
            imax=Math.max(imax,nums[k]);

        }
        return ans;
    }
}