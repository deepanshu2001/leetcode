class Solution {
    public long f(int ind,int [][]questions,long dp[]){
        if(ind>=questions.length){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        long take=questions[ind][0]+f(ind+questions[ind][1]+1,questions,dp);
        long nottake=0+f(ind+1,questions,dp);
        return dp[ind]=Math.max(take,nottake);
    }
    public long mostPoints(int[][] questions) {
       
        int max=0;
        for(int i=0;i<questions.length;i++){
            max=Math.max(max,questions[i][1]);
        }
        int n=questions.length;
         long dp[]=new long[n+max+1];
        dp[n]=0;
        for(int i=n-1;i>=0;i--){
            long take=questions[i][0]+dp[i+questions[i][1]+1];
            long nottake=dp[i+1];
            dp[i]=Math.max(take,nottake);
        }
        return dp[0];
    }
}