class Solution {
    public boolean increasingTriplet(int[] nums) {
        int n=nums.length;
        int left_min[]=new int[n];
        left_min[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            left_min[i]=Math.min(left_min[i-1],nums[i]);
        }
        int right_max[]=new int[n];
        right_max[n-1]=nums[n-1];
        for(int i=n-2;i>=0;i--){
            right_max[i]=Math.max(right_max[i+1],nums[i]);
        }
        for(int i=0;i<n;i++){
            if(nums[i]>left_min[i] && nums[i]<right_max[i]){
                return true;
            }
        }
        return false;
    }
}