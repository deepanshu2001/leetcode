class Solution {
    class Pair{
    int first;
    int second;
    int third;
    public Pair(int first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}

    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        int rows=heights.length;
        int columns=heights[0].length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        int dist[][]=new int[rows][columns];
        for(int i=0;i<rows;i++){
            for(int j=0;j<columns;j++){
                dist[i][j]=(int)1e9;
            }
        }
        dist[0][0]=0;
        
        pq.add(new Pair(0,0,0));
        while(pq.size()!=0){
            Pair pair=pq.remove();
            int dis=pair.first;
            int row=pair.second;
            int col=pair.third;
            if(row==rows-1 && col==columns-1){
                return dis;
            }
            for(int i=0;i<4;i++){
                int nrow=row+deltarow[i];
                int ncol=col+deltacol[i];
                if(nrow>=0 && nrow<rows && ncol>=0 && ncol<columns){
                    int cal=Math.max(dis,Math.abs(heights[row][col]-heights[nrow][ncol]));
                    if(cal<dist[nrow][ncol]){
                        dist[nrow][ncol]=cal;
                        pq.add(new Pair(cal,nrow,ncol));
                    }
                }
            }
            
        }
        return -1;
    }
}