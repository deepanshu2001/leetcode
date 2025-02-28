class Solution {
    public boolean check(int[] nums) {
        int rotation_cnt=0;
        int n=nums.length;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>nums[(i+1)%n]){
                rotation_cnt++;
            }

            if(rotation_cnt>1){
                return false;
            }
        }
        return true;
    }
}