class Solution {
    public boolean isSafe(char [][]board,int row,int col,int num){
        //checking row
        for(int r=0;r<board.length;r++){
            if(board[r][col]==(char)(num+'0')){
                return false;
            }
        }
        //checking col
        for(int i=0;i<board[0].length;i++){
            if(board[row][i]==(char)(num+'0')){
                return false;
            }
        }
        //checking square grid
        int sqrt=(int)(Math.sqrt(board.length));
        int rowStart=row-row%sqrt;
        int colStart=col-col%sqrt;
        for(int i=rowStart;i<rowStart+sqrt;i++){
            for(int j=colStart;j<colStart+sqrt;j++){
                if(board[i][j]==(char)(num+'0')){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean solve(char [][]board){
        int n=board.length;
        int m=board[0].length;
        //check the first empty cell;
        int row=-1;
        int col=-1;
        boolean isEmpty=false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(board[i][j]=='.'){
                    row=i;
                    col=j;
                    isEmpty=true;
                    break;
                }
            }
            if(isEmpty){
               break; 
            }
        }
        if(!isEmpty){
            //solved
            return true;
        }
        //backtracking logic
        for(int num=1;num<=9;num++){
            if(isSafe(board,row,col,num)){
                board[row][col]=(char)(num+'0');
                if(solve(board)){
                    return true;
                }
                else{
                    //backtrack
                    board[row][col]='.';
                }
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board);
    }
}
