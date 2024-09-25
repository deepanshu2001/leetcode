class Solution {
    public int help(int ind,int[] cost,int dp[]){
        if(ind==0||ind==1){
            return cost[ind];
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int left=help(ind-1,cost,dp);
        int right=help(ind-2,cost,dp);
        return dp[ind]=cost[ind]+Math.min(left,right);
    }
    public int minCostClimbingStairs(int[] cost) {
        //memoziation'
        int n=cost.length;
        int dp[]=new int[n+1];
        Arrays.fill(dp,-1);
        return Math.min(help(n-1,cost,dp),help(n-2,cost,dp));
    }
}