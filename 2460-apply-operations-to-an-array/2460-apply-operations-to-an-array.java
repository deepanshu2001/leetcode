class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-2;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        int j=nums.length-1;
        int ans[]=new int[nums.length];
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
               ans[ind]=nums[i];
               ind++;
            }
        }
        return ans;
    }
}