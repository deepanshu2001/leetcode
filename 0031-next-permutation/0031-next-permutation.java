class Solution {
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int i,int j,int []nums){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        //find the break point
        int ind=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,nums.length-1,nums);
            return;
        }
        //find next greater number that ind;
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(i,ind,nums);
                break;
            }
        }
        reverse(ind+1,nums.length-1, nums);
    }
}