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
        int n=cost.length;
        dp[n-1]=cost[n-1];
        for(int i=n-2;i>=0;i--){
           int one_step=cost[i]+dp[i+1];
           int two_step=cost[i]+dp[i+2];
           dp[i]=Math.min(one_step,two_step);
        }
        return Math.min(dp[0],dp[1]);
       

    }
}