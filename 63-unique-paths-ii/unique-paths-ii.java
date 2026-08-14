class Solution {
    public int f(int row,int col,int [][]grid,int dp[][]){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0||col<0||grid[row][col]==1){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int left=f(row,col-1,grid,dp);
        int up=f(row-1,col,grid,dp);
        return dp[row][col]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        int dp[][]=new int[n+1][m+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,obstacleGrid,dp);
    }
}