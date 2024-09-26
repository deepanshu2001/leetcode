class Solution {
    public int f(int row,int col,int [][]grid,int dp[][]){
        if(row==0 && col==0){
            return grid[0][0];
        }
        if(row<0||col<0){
            return (int)Math.pow(10,9);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up=grid[row][col]+f(row-1,col,grid,dp);
        int left=grid[row][col]+f(row,col-1,grid,dp);
        return dp[row][col]=Math.min(up,left);
    }
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,grid,dp);
    }
}