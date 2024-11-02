class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i=0;
        int j=0;
        int ans=0;
        while(j<nums.length){
            if(nums[j]==0){
               while(nums[j]==0){
               j++;
               }
                i=j;
            }
          
         
           ans=Math.max(ans,j-i+1);
           j++;
        }
        return ans;
    }
}