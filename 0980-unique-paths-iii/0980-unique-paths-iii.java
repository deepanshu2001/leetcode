class Solution {
    int cnt=0;
    int totalsteps=0;
    public void dfs(int row,int col,int grid[][],int vis[][],int steps){
        if(grid[row][col]==2){
            if(totalsteps==steps){
                cnt++;
            }
            return;
        }
        vis[row][col]=1;
        int n=vis.length;
        int m=vis[0].length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && grid[nrow][ncol]!=-1){
                dfs(nrow,ncol,grid,vis,steps+1);
            }
        }
        vis[row][col]=0;
    }
    public int uniquePathsIII(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int row=-1;
        int col=-1;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    row=i;
                    col=j;
                }
                if(grid[i][j]!=-1){
                    totalsteps++;
                }
            }
        }
        dfs(row,col,grid,vis,1);
        return cnt;
    }
}