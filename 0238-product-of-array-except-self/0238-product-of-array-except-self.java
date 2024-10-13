class Solution {
    public int[] productExceptSelf(int[] nums) {
        int ans[]=new int[nums.length];
        int prefix=1;
        for(int i=0;i<nums.length;i++){
            ans[i]=prefix;
            prefix=prefix*nums[i];
        }
        int suff=1;
        for(int i=nums.length-1;i>=0;i--){
            ans[i]=ans[i]*suff;
            suff=suff*nums[i];
        }
        return ans;
    }
}