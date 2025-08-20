class Solution {
    int deltarow[]={-1,0,1,0};
    int deltacol[]={0,1,0,-1};
    public void dfs(int [][]image,int row,int col,int [][]vis,int preColor,int newColor){
        int n=image.length;
        int m=image[0].length;
        vis[row][col]=1;
        image[row][col]=newColor;
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==preColor && vis[nrow][ncol]==0){
                dfs(image,nrow,ncol,vis,preColor,newColor);
            }
        }

    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m=image.length;
        int n=image[0].length;
        int vis[][]=new int[m][n];
        int preColor=image[sr][sc];
        dfs(image,sr,sc,vis,preColor,color);
        return image;
    }
}