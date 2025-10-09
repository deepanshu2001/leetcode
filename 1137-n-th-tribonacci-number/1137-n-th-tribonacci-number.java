class Solution {
    public int f(int []dp,int n){
        if(n==2||n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n]!=-1){
            return dp[n];
        }
        return dp[n]=f(dp,n-1)+f(dp,n-2)+f(dp,n-3);
    }
    public int tribonacci(int n) {
        if(n==0){
            return 0;
        }
        if(n==1||n==2){
            return 1;
        }
        int dp[]=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        }
        return dp[n];
    }
}