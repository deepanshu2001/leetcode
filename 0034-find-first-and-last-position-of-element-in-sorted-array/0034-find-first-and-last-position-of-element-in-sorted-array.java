class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<target){
                s=mid+1;
            }
            else if(nums[mid]>target){
                e=mid-1;
            }
            else{
                s=mid;
                e=mid;
                while(e>-1 && nums[e]==target){
                    e=e-1;
                }
                while(s<nums.length && nums[s]==target){
                    s=s+1;
                }
                int arr[]={e+1,s-1};
                return arr;
            }
        }
        return new int[]{-1,-1};
    }
}