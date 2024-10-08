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
        int up=f(row-1,col,dp);
        int left=f(row,col-1,dp);
        return dp[row][col]=left+up;
    }
    public int uniquePaths(int m, int n) {
        int dp[][]=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,dp);
    }
}