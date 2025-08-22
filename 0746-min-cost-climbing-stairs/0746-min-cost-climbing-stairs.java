class Solution {
    public int f(int ind,int cost[],int dp[]){
        if(ind>=cost.length){
            return 0;
        }

        if(dp[ind]!=-1){
            return dp[ind];
        }
        int one_step=cost[ind]+f(ind+1,cost,dp);
        int two_step=cost[ind]+f(ind+2,cost,dp);
        return dp[ind]= Math.min(one_step,two_step);
    }
    public int minCostClimbingStairs(int[] cost) {
        int []dp=new int[cost.length+1];
        Arrays.fill(dp,-1);
        return Math.min(f(0,cost,dp),f(1,cost,dp));

    }
}