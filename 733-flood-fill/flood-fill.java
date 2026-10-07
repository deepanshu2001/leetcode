class Solution {
    int deltarow[]={-1,0,1,0};
    int deltacol[]={0,1,0,-1};
    public void bfs(int image[][],int [][]vis,int row,int col,int color,int newColor){
        vis[row][col]=1;
        int n=image.length;
        int m=image[0].length;
        image[row][col]=newColor;
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==color && vis[nrow][ncol]==0){
                bfs(image,vis,nrow,ncol,color,newColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n=image.length;
        int m=image[0].length;
        int vis[][]=new int[n][m];
        bfs(image,vis,sr,sc,image[sr][sc],color);
        return image;
    }
}