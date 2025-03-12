class Solution {
    public int maximumCount(int[] nums) {
        int pos=0;
        int neg=0;
        int s=0;
        int e=nums.length-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]<0){
                s=mid+1;
            }
            else if(nums[mid]>0){
                e=mid-1;
            }
            else if(nums[mid]==0){
                e=mid-1;
            }
        }
        neg=e+1;
        while(s<nums.length && nums[s]==0){
            s++;
        }
        pos=nums.length-s;
        return Math.max(pos,neg);
    }
}