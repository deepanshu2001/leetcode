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
                int i=mid;
                int j=mid;
                while(nums[i]==target){
                    i--;
                }
                while(nums[j]==target){
                    j++;
                }
                return new int[]{i+1,j-1};
            }
        }
        return new int[]{-1,-1};
    }
}