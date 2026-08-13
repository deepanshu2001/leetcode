class Solution {
    
    public int rob(int[] nums) {
      int prev1=nums[0];
      int prev2=0;
      for(int i=1;i<nums.length;i++){
        int not_take=prev1;
        int take=nums[i];
        if(i>1){
            take+=prev2;
        }
        int curr=Math.max(take,not_take);
        prev2=prev1;
        prev1=curr;

      }
       return prev1;
    }
}