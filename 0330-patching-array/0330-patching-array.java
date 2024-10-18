class Solution {
    public int minPatches(int[] nums, int n) {
        int max=0;
        int add=0;
        int i=0;
        while(max<n){
            if(i<nums.length && nums[i]<=max+1){
                max+=nums[i];
                i++;
            }
            else{
                add++;
                max+=max+1;
            }
        }
        return add;
    }
}