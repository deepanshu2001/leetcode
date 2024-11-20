class Solution {
    int ans = 0;
    int cnt = 0;
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void bfs(int i,int j,int [][]grid,int [][]vis){
       vis[i][j]=1;
       cnt++;
       Queue<Pair> queue=new LinkedList<>();
       queue.add(new Pair(i,j));
       int deltarow[]={-1,0,1,0};
       int deltacol[]={0,1,0,-1};
       int n=grid.length;
       int m=grid[0].length;
       while(!queue.isEmpty()){
        Pair p=queue.remove();
        int row=p.first;
        int col=p.second;
        for(int k=0;k<4;k++){
            int nrow=row+deltarow[k];
            int ncol=col+deltacol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                queue.add(new Pair(nrow,ncol));
                cnt++;
                vis[nrow][ncol]=1;
            }
        }
       }
       ans=Math.max(ans,cnt);
    }
    public void dfs(int row, int col, int[][] grid, int[][] vis) {
        vis[row][col] = 1;
        cnt++;  // Increment the area for each land cell visited
        int n = grid.length;
        int m = grid[0].length;
        int deltarow[] = {-1, 0, 1, 0};
        int deltacol[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nrow = row + deltarow[i];
            int ncol = col + deltacol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, grid, vis);
            }
        }
    }
    
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    cnt=0;
                    bfs(i,j,grid,vis);
                }
            }
        }
        return ans;
    }
}
