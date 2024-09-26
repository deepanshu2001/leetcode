class Solution {
    public int uniquePaths(int m, int n) {
        //tabulation
        int dp[][]=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    dp[0][0]=1;
                    continue;
                }
                int left=0;
                int up=0;
                if(i>0){
                    up=dp[i-1][j];
                } 
                if(j>0){
                    left=dp[i][j-1];
                }
                dp[i][j]=left+up;
            }
        }
        return dp[m-1][n-1];
    }
}