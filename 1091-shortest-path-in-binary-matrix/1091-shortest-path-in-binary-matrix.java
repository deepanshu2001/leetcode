class Solution {
    class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int shortestPathBinaryMatrix(int[][] grid) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        int n=grid.length;
        int m=grid[0].length;
        if(grid[0][0]!=0||grid[n-1][m-1]!=0){
          return -1;
        }
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        pq.add(new Pair(0,0,0));
        int deltarow[]={1,0,-1,0,1,-1,1,-1};
        int deltacol[]={0,1,0,-1,1,-1,-1,1};
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int dis=p.first;
            int row=p.second;
            int col=p.third;
            if(row==n-1 && col==m-1){
                return dis+1;
            }
            for(int i=0;i<8;i++){
                int nrow=row+deltarow[i];
                int ncol=col+deltacol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==0){
                    if(1+dis<dist[nrow][ncol]){
                        dist[nrow][ncol]=1+dis;
                        pq.add(new Pair(dis+1,nrow,ncol));
                    }
                }
            }
        }
        return -1;

    }
}