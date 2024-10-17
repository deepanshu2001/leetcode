class Solution {
    public void moveZeroes(int[] nums) {
        int arr[]=new int[nums.length];
        int i=0;
        int j=nums.length-1;
        for(int k=0;k<nums.length;k++){
            if(nums[k]==0){
                arr[j]=0;
                j--;
            }
            else{
                arr[i]=nums[k];
                i++;
            }
        }
        for(int k=0;k<nums.length;k++){
            nums[k]=arr[k];
        }
    }
}