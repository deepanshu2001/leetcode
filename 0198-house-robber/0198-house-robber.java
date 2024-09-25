class Solution {
    public int help(int ind,int []nums,int dp[]){
        if(ind==0){
            return nums[0];
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        //pick
        int pick=nums[ind]+help(ind-2,nums,dp);
        //not pick
        int notpick=0+help(ind-1, nums,dp);
        return dp[ind]= Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        //memoization;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return help(n-1,nums,dp);
    }
}