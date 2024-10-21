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
    public void bfs(int [][]mat,int i,int j,int [][]ans){
       Queue<Pair> queue=new LinkedList<>();
       
       int deltarow[]={-1,0,1,0};
       int deltacol[]={0,1,0,-1};
       int n=mat.length;
       int m=mat[0].length;
       int vis[][]=new int[n][m];
       vis[i][j]=1;
       queue.add(new Pair(0,i, j));
       while(!queue.isEmpty()){
        Pair pair=queue.poll();
        int dist=pair.first;
        int row=pair.second;
        int col=pair.third;
        if(mat[row][col]==0){
            ans[i][j]=dist;
            break;
        }
       
        for(int k=0;k<4;k++){
            int nrow=row+deltarow[k];
            int ncol=col+deltacol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                queue.add(new Pair(dist+1,nrow,ncol));
                vis[nrow][ncol]=1;
            }
        }
        
       }
    }
    public int[][] updateMatrix(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int ans[][]=new int[n][m];
       
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j]==0){
                    ans[i][j]=0;
                }
                else{
                    bfs(mat,i,j,ans);
                }
            }
        }
        return ans;
    }
}