class Solution {
    public int find_ways(int n,int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=find_ways(n-1,dp)+find_ways(n-2,dp);
    }
    public int climbStairs(int n) {
       int dp[]=new int[n+1];
       Arrays.fill(dp,-1);
       return find_ways(n,dp);
    }
}