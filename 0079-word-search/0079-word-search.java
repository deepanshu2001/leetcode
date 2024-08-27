class Solution {
    public boolean dfs(char [][]board,int [][]vis,int row,int col,String word,int index){
        if(index==word.length()){
            return true;
        }
        vis[row][col]=1;
        int n=board.length;
        int m=board[0].length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0){
                if(board[nrow][ncol]==word.charAt(index)){
                    if(dfs(board,vis,nrow,ncol,word,index+1)==true){
                        return true;
                    }
                    
                }
            }
        }
        vis[row][col]=0;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int n=board.length;
        int m=board[0].length;
        int [][]vis=new int[n][m];
        int row=-1;
        int col=-1;
        char ch=word.charAt(0);
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
              if(board[i][j]==ch){
                
                if(dfs(board,vis,i,j,word,1)==true){
                    return true;
                }
              }
            }
        }
        return false;
    }
}