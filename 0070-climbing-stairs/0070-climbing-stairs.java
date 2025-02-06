class Solution {
    public int f(int n,int dp[]){
        if(n<=1){
            return 1;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=f(n-1,dp)+f(n-2,dp);
    }
    public int climbStairs(int n) {
        int first=1;
        int second=1;
        for(int i=2;i<=n;i++){
            int third=first+second;
            first=second;
            second=third;
        }
        return second;
    }
}