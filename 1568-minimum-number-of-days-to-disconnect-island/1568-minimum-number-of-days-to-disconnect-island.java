class Solution {
    public void dfs(int r,int c,int [][]grid,int vis[][]){
        vis[r][c]=1;
        int n=grid.length;
        int m=grid[0].length;
        int row[]={-1,0,1,0};
        int col[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=r+row[i];
            int ncol=c+col[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                dfs(nrow,ncol,grid,vis);
            }
        }
    }
    public int checkislands(int [][]grid){
       int n=grid.length;
       int m=grid[0].length;
       int vis[][]=new int[n][m];
       int cnt=0;
       for(int i=0;i<grid.length;i++){
        for(int j=0;j<grid[0].length;j++){
            if(grid[i][j]==1 && vis[i][j]==0){
              dfs(i,j,grid,vis);
              cnt++;
            }
        }
       }
       return cnt;
    }
    public int minDays(int[][] grid) {
       //base case
       //check for zero
       int n=grid.length;
       int m=grid[0].length;
       int ans=checkislands(grid);
       if(ans!=1){
        return 0;
       }
       //check for each case
       for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==1){
                grid[i][j]=0;
                int check=checkislands(grid);
                if(check!=1){
                    return 1;
                }
                grid[i][j]=1;
            }
        }
       }
       return 2;
    }
}