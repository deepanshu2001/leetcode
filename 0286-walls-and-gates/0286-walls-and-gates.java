class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public void wallsAndGates(int[][] rooms) {
        int n=rooms.length;
        int m=rooms[0].length;
        Queue<Pair> queue=new LinkedList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(rooms[i][j]==0){
                    queue.add(new Pair(i,j));
                }
            }
        }
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        while(!queue.isEmpty()){
            Pair pair=queue.remove();
            int row=pair.first;
            int col=pair.second;
            for(int i=0;i<4;i++){
                int nrow=row+deltarow[i];
                int ncol=col+deltacol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && rooms[nrow][ncol]==Integer.MAX_VALUE){
                    rooms[nrow][ncol]=rooms[row][col]+1;
                    queue.add(new Pair(nrow,ncol));
                }
            }

        }
    }
}