class Solution {
    public int f(int row,int col,int grid[][],int dp[][]){
        if(row==0 && col==0){
            return grid[row][col];
        }
        if(row<0 || col<0){
            return (int)Math.pow(10,7);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int left=grid[row][col]+f(row,col-1,grid,dp);
        int up=grid[row][col]+f(row-1,col,grid,dp);
        return dp[row][col]=Math.min(left,up);
    }

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][]=new int[m+1][n+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(m-1,n-1,grid,dp);
    }
}