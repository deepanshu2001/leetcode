class Solution {
    public void dfs(char [][]grid,int vis[][],int row,int col){
       vis[row][col]=1;
       int deltarow[]={-1,0,1,0};
       int deltacol[]={0,1,0,-1};
       int n=grid.length;
       int m=grid[0].length;
       for(int i=0;i<4;i++){
        int nrow=row+deltarow[i];
        int ncol=col+deltacol[i];
        if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0 ){
            dfs(grid,vis,nrow,ncol);
        }
       }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid.length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(grid,vis,0,0);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}