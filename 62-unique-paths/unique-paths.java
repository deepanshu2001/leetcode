class Solution {
    public int f(int row,int col,int dp[][]){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0||col<0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int left=f(row,col-1,dp);
        int up=f(row-1,col,dp);
        return dp[row][col]=up+left;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m+1][n+1];
        dp[0][0]=1;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0){
                    continue;
                }
                int left=0;
                if(j-1>=0){
                    left=dp[i][j-1];
                }
                int up=0;
                if(i-1>=0){
                    up=dp[i-1][j];
                }
                dp[i][j]=up+left;
            }
        }
        return dp[m-1][n-1];
    }
}