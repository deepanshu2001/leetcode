class Solution {
    public int findPeakElement(int[] nums) {
        if(nums.length==1||nums[0]>nums[1]){
            return 0;
        }
        if(nums[nums.length-1]>nums[nums.length-2]){
            return nums.length-1;
        }
        return f(nums);
        
    }
    public int f(int nums[]){
        int s=1;
        int e=nums.length-2;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]>nums[mid+1] && nums[mid]>nums[mid-1]){
                return mid;
            }
            else if(nums[mid]>nums[mid+1]){
                e=mid-1;
            }
            else if(nums[mid]<nums[mid+1]){
                s=mid+1;
            }
        }
        return -1;
    }
}