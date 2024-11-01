class TicTacToe {
    int matrix[][];
    public TicTacToe(int n) {
        matrix=new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        matrix[row][col]=player;
        //checking row;
        boolean row_check=true;
        for(int i=0;i<matrix.length;i++){
            if(matrix[row][i]!=player){
                row_check=false;
                break;
            }
        }
        //checking col
        boolean col_check=true;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][col]!=player){
                col_check=false;
                break;
            }
        }
        //checking left diagonal
        boolean left_diag=true;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][i]!=player){
                left_diag=false;
                break;
            }
        }
        boolean right_diag=true;
        int j=matrix.length-1;
        for(int i=0;i<matrix.length;i++){
            if(matrix[i][j]!=player){
                right_diag=false;
                break;
            }
            j--;
        }
        if(row_check||col_check||left_diag||right_diag){
            return player;
        }
        return 0;

    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */