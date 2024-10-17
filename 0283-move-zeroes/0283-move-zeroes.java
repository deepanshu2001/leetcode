class Solution {
    public void moveZeroes(int[] nums) {
        int i=0;
        int j=0;
        while(i<j && nums[i]!=0){
            i++;
        }
        while(j<nums.length && nums[j]==0){
            j++;
        }
        while(i<nums.length && j<nums.length){
            if(nums[i]==0 && nums[j]!=0 && i<j){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
               
            }
            if(nums[i]!=0){
                i++;
            }
            if(nums[j]==0||j<i){
                j++;
            }
        }
    }
}