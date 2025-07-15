class Solution {
    int min=Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            min=Math.min(nums[mid],min);
            if(nums[s]<=nums[e]){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return min;
    }
}