class Solution {
    public int f(int[][] obstacleGrid,int row,int col,int [][]dp){
        if(row>=0 && col>=0 && obstacleGrid[row][col]==1){
            return 0;
        }
        if(row==0 && col==0){
            return 1;
        }
        if(row<0||col<0){
            return 0;
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int up=f(obstacleGrid,row-1,col,dp);
        int left=f(obstacleGrid,row,col-1,dp);
        return dp[row][col]=left+up;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int dp[][]=new int[m][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(obstacleGrid,m-1,n-1,dp);
    }
}