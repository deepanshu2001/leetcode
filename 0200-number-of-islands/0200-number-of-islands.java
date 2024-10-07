class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void bfs(char [][]grid,int vis[][],int i,int j){
       Queue<Pair> q=new LinkedList<>();
       int deltarow[]={-1,0,1,0};
       int deltacol[]={0,1,0,-1};
       int n=grid.length;
       int m=grid[0].length;
       vis[i][j]=0;
       q.add(new Pair(i,j));
       while(!q.isEmpty()){
         Pair pair=q.remove();
         int row=pair.first;
         int col=pair.second;
         vis[row][col]=1;
         for(int p=0;p<4;p++){
              int nrow=row+deltarow[p];
              int ncol=col+deltacol[p];
              if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]=='1' && vis[nrow][ncol]==0){
                q.add(new Pair(nrow,ncol));
                vis[nrow][ncol]=1;
              }
         }
           
       }
    }
    public int numIslands(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        int cnt=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]=='1' && vis[i][j]==0){
                    bfs(grid,vis,i,j);
                    cnt++;
                }
            }
        }
        return cnt;
    }
}