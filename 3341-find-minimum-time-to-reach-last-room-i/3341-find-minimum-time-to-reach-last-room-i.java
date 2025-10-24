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
    public int minTimeToReach(int[][] moveTime) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.first-b.first);
        int n=moveTime.length;
        int m=moveTime[0].length;
        int vis[][]=new int[n][m];
        int dist[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty()){
            Pair pair=pq.remove();
            int time=pair.first;
            int row=pair.second;
            int col=pair.third;
            if(vis[row][col]==1){
                continue;
            }
            vis[row][col]=1;
            for(int i=0;i<4;i++){
                int nrow=row+deltarow[i];
                int ncol=col+deltacol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m){
                    int total_t=Math.max(time,moveTime[nrow][ncol])+1;
                    if(total_t<dist[nrow][ncol]){
                        dist[nrow][ncol]=total_t;
                        pq.add(new Pair(total_t,nrow,ncol));
                    }
                }
            }
        }
        return dist[n-1][m-1];
    }
}