class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            while(j<nums.length && nums[j]==1){
                j++;
            }
            ans=Math.max(ans,j-i);
            j++;
            i=j;
        }
        return ans;
    }
}