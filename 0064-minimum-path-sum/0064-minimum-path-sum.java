class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][]=new int[n][m];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    dp[i][j]=grid[0][0];
                    continue;
                }
                int up=grid[i][j];
                int left=grid[i][j];
                if(i>0){
                    up+=dp[i-1][j];
                }
                else{
                    up+=(int)Math.pow(10,9);
                }
                if(j>0){
                    left+=dp[i][j-1];
                }
                else{
                    left+=(int)Math.pow(10,9);
                }
                dp[i][j]=Math.min(up,left);
            }
        }
       return dp[n-1][m-1];
    }
}