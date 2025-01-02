class Solution {
    public void moveZeroes(int[] nums) {
        //Brute force way
        int arr[]=new int[nums.length];
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
               arr[ind]=nums[i];
               ind++;
            }
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=arr[i];
        }
    }
}