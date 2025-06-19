class Solution {
    public int f(int row,int col,int [][]grid,int m,int n,int dp[][]){
        if(row==m-1 && col==n-1){
            return grid[m-1][n-1];
        }
        if(row>=m||col>=n){
            return (int)Math.pow(10,9);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int down=0;
        int right=0;
        down+=grid[row][col]+f(row+1,col,grid,m,n,dp);
        right+=grid[row][col]+f(row,col+1,grid,m,n,dp);
        return dp[row][col]=Math.min(down,right);
    }
    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,grid,m,n,dp);
    }
}