class Solution {
    public int minSteps(int n) {
        if(n==1){
            return 0;
        }
        int dp[][]=new int[n+1][n/2+1];
       
        return 1+helper(1,1,n,dp);
    }
    public int helper(int orig,int copy,int n,int dp[][]){
        if(orig==n){
            return 0;
        }
        if(orig>n){
            return 1000;
        }
        if(dp[orig][copy]!=0){
            return dp[orig][copy];
        }
        int copyAll=2+helper(orig*2,copy,n,dp);
        int paste=1+helper(orig+copy,copy,n,dp);
        return dp[orig][copy]=Math.min(paste,copyAll);
    }
}