class Solution {
    public boolean dfs(char [][]board,int [][]vis,int row,int col,String word,int ind){
        if(ind==word.length()){
            return true;
        }
        vis[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=deltarow[i]+row;
            int ncol=deltacol[i]+col;
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && word.charAt(ind)==board[nrow][ncol]){
                if(dfs(board,vis,nrow,ncol,word,ind+1)==true){
                    return true;
                }
            }
        }
        vis[row][col]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int vis[][]=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(word.charAt(0)==board[i][j]){
                
                if(dfs(board,vis,i,j,word,1)==true){
                    return true;
                }
                
              }
            }
        }
        return false;
    }
}