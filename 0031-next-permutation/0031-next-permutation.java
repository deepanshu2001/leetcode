class Solution {
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void reverse(int i,int j,int nums[]){
        while(i<j){
            swap(i,j,nums);
            i++;
            j--;
        }
    }
    public void nextPermutation(int[] nums) {
        int ind=-1;
        int n=nums.length-2;
        //find the break point;
        for(int i=n;i>=0;i--){
            if(nums[i]<nums[i+1]){
                ind=i;
                break;
            }
        }
        if(ind==-1){
            reverse(0,nums.length-1, nums);
            return;
        }
        //find the next greater;
        for(int i=nums.length-1;i>ind;i--){
            if(nums[i]>nums[ind]){
                swap(i,ind,nums);
                break;
            }
        }
        //reverse the res;
        reverse(ind+1,nums.length-1, nums);
        
    }
}