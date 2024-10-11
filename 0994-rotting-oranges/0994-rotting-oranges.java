class Solution {
    public class Pair{
        int first;
        int second;
        int third;
        public Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.add(new Pair(0,i,j));
                }
            }
        }
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        int t=0;

        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            int time=pair.first;
            int row=pair.second;
            int col=pair.third;
            t=time;
            for(int i=0;i<4;i++){
                int nrow=row+deltarow[i];
                int ncol=col+deltacol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1){
                    grid[nrow][ncol]=2;
                    queue.add(new Pair(time+1,nrow,ncol));
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    return -1;
                }
            }
        }
        return t;
    }
}