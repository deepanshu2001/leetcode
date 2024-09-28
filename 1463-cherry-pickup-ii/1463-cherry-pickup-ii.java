class Solution {
    public int f(int row,int c1,int c2,int [][]grid,int dp[][][]){
        int n=grid.length;
        int m=grid[0].length;
        
        if(c1<0||c2<0||c1>=m||c2>=m){
            return (int)Math.pow(-10,9);
        }
        if(dp[row][c1][c2]!=-1){
            return dp[row][c1][c2];
        }
        if(row==grid.length-1){
            if(c1==c2){
                return dp[row][c1][c2]=grid[row][c1];
            }
            else{
                return dp[row][c1][c2]=grid[row][c1]+grid[row][c2];
            }
        }
        
        int maxi=0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int sum=0;
                if(c1==c2){
                    sum=grid[row][c1]+f(row+1,c1+i,c2+j,grid,dp);
                }
                else{
                    sum=grid[row][c1]+grid[row][c2]+f(row+1,c1+i,c2+j,grid,dp);
                }
                maxi=Math.max(maxi,sum);
            }
        }
        return dp[row][c1][c2]=maxi;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int dp[][][]=new int[n][m][m];
        for(int row[][]:dp){
            for(int col[]:row){
                Arrays.fill(col,-1);
            }
        }
        return f(0,0,m-1,grid,dp);
    }
}