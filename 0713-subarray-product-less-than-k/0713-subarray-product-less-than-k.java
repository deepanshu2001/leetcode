class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int prod=1;
            int j=i;
            while(j<nums.length && prod*nums[j]<k){
                prod=prod*nums[j];
                j++;
            }
            ans+=j-i;
        }
        return ans;
    }
}