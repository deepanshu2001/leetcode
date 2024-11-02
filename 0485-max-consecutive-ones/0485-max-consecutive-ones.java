class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            i=j;
           while(j<nums.length && nums[j]!=0){
            j++;
           }
           ans=Math.max(ans,j-i);
           j++;
        }
        return ans;
    }
}