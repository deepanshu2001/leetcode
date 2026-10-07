class Solution {
    int deltarow[]={-1,0,1,0};
    int deltacol[]={0,1,0,-1};
    public void dfs(int row,int col,int vis[][],char grid[][]){
        vis[row][col]=1;
        int n=grid.length;
        int m=grid[0].length;
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                dfs(nrow,ncol,vis,grid);
            }
        }
    }
    public int numIslands(char[][] grid) {
        List<List<Integer>> adj=new ArrayList<>();
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    dfs(i,j,vis,grid);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}