class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans=new ArrayList<>();
        char board[][]=new char[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        int left[]=new int[n];
        int lowerdiagonal[]=new int[2*n-1];
        int upperdiagonal[]=new int[2*n-1];
        dfs(0,board,ans,left,lowerdiagonal,upperdiagonal,n);
        return ans;
    }
    public List<String> contruct(char board[][]){
        List<String> res=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            String s=new String(board[i]);
            res.add(s);
        }
        return res;
    }
    public void dfs(int col,char [][]board,List<List<String>> ans,int []left,int []lowerdiagonal,int []upperdiagonal,int n){
        if(col==board[0].length){
            ans.add(contruct(board));
        }
        for(int row=0;row<board.length;row++){
            if(left[row]==0 && lowerdiagonal[row+col]==0 & upperdiagonal[n-1+col-row]==0){
                board[row][col]='Q';
                left[row]=1;
                lowerdiagonal[row+col]=1;
                upperdiagonal[n-1+col-row]=1;
                dfs(col+1,board,ans,left,lowerdiagonal,upperdiagonal,n);
                board[row][col]='.';
                left[row]=0;
                lowerdiagonal[row+col]=0;
                upperdiagonal[n-1+col-row]=0;
            }
        }
       
    }
}