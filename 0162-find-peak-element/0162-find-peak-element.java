class Solution {
    public int findPeakElement(int[] nums) {
        int s=0;
        int e=nums.length-1;
        if(nums.length==1){
            return 0;
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid==0 && nums[0]>nums[1]){
                return 0;
            }
            if(mid==nums.length-1 && nums[mid]>nums[mid-1]){
                return nums.length-1;
            }
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            if(nums[mid]<nums[mid+1]){
                s=mid+1;
            }
            else if(nums[mid]<nums[mid-1]){
                e=mid-1;
            }
        }
        return -1;
    }
}