class Solution {
    public void moveZeroes(int[] nums) {
        //optimized version
        if(nums.length==1){
            return;
        }
        int j=nums.length-1;
        int i=0;
        while(i<j){
            if(nums[i]==0){
                int k=i;
                while(k<j){
                    nums[k]=nums[k+1];
                    k++;
                }
                nums[j]=0;
                j--;
            }
            else{
                i++;
            }
        }
    }
}