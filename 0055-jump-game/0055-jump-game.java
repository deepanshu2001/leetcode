class Solution {
    public boolean canJump(int[] nums) {
        long max=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            if(i>max){
                return false;
            }
            max=Math.max(max,i+nums[i]);
        }
        return true;
    }
}