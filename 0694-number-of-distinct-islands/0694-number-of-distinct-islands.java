class Solution {
    class Pair{
        int first;
        int second;
        Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    int deltarow[]={-1,0,1,0};
    int deltacol[]={0,1,0,-1};
    public void bfs(int i,int j,int [][]grid,int vis[][],List<String> list){
        int n=grid.length;
        int m=grid[0].length;
        Queue<Pair> queue=new LinkedList<>();
        queue.add(new Pair(i,j));
        vis[i][j]=1;
        list.add("0,0");
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            int row=pair.first;
            int col=pair.second;
            for(int k=0;k<4;k++){
               int nrow=row+deltarow[k];
               int ncol=col+deltacol[k];
               if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1 && vis[nrow][ncol]==0){
                vis[nrow][ncol]=1;
                queue.add(new Pair(nrow,ncol));
                list.add((nrow-row)+","+(ncol-col));
               }
            }
        }
    }
    public int numDistinctIslands(int[][] grid) {
        Set<List<String>> set=new HashSet<>();
        int n=grid.length;
        int m=grid[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && vis[i][j]==0){
                    List<String> list=new ArrayList<>();
                    bfs(i,j,grid,vis,list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}