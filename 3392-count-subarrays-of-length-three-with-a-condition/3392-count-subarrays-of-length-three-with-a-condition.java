class Solution {
    public int countSubarrays(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length-2;i++){
            int sum=nums[i]+nums[i+2];
            if(sum==(nums[i+1])*1.0/2){
                cnt++;
            }
        }
        return cnt;
    }
}