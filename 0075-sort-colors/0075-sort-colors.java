class Solution {
    public void swap(int first,int second,int []nums){
        int temp=nums[first];
        nums[first]=nums[second];
        nums[second]=temp;
    }
    public void sortColors(int[] nums) {
        int mid=0;
        int high=nums.length-1;
        int low=0;
        while(mid<=high){
            if(nums[mid]==0){
              swap(low,mid,nums);
              low++;
              mid++;
            }
            else if(nums[mid]==1){
              mid++;
            }
            else{
               swap(mid,high,nums);
               high--;
            }
        }
    }
}