class Solution {
    public int findPivot(int nums[]){
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid<e && nums[mid]>nums[mid+1]){
                return mid;
            }
            else if(s<mid && nums[mid-1]>nums[mid]){
                return mid-1;
            }
            else if(nums[s]>=nums[mid]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return -1;
    }
    public int findMin(int[] nums) {
        int pivot=findPivot(nums);
        int a=nums[0];
        int b=nums[pivot+1];
        return Math.min(a,b);
    }
}