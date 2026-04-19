class Solution {
    public int dominantIndex(int[] nums) {
        int ind=-1;
        int num=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>num){
               num=nums[i];
               ind=i;
            }
        }
        for(int i=0;i<nums.length;i++){
            if(i!=ind){
                if(nums[ind]<nums[i]*2){
                    return -1;
                }
            }
        }
        return ind;
    }
}