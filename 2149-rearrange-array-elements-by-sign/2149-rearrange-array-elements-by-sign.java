class Solution {
    public int[] rearrangeArray(int[] nums) {
        int ans[]=new int[nums.length];
        int i=0;
        int j=0;
        int ind=0;
        while(i<nums.length && j<nums.length){
            while(nums[i]<0){
                i++;
            }
            while(nums[j]>0){
                j++;
            }
            ans[ind]=nums[i];
            ind++;
            i++;
            ans[ind]=nums[j];
            j++;
            ind++;
        }
        return ans;
    }
}