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
    public int[][] updateMatrix(int[][] mat) {
        Queue<Pair> q=new LinkedList<>();
        int n=mat.length;
        int m=mat[0].length;
        int vis[][]=new int[n][m];
        int ans[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    vis[i][j]=1;
                    q.add(new Pair(0,i,j));
                }
            }
        }
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        while(!q.isEmpty()){
            Pair p=q.remove();
            int dis=p.first;
            int row=p.second;
            int col=p.third;
            ans[row][col]=dis;
            for(int i=0;i<4;i++){
                int nrow=deltarow[i]+row;
                int ncol=deltacol[i]+col;
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                    vis[nrow][ncol]=1;
                    q.add(new Pair(dis+1,nrow,ncol));
                }
            }
        }
        return ans;
    }
}