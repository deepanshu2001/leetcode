class TicTacToe {
    int rows[];
    int cols[];
    int diag;
    int anti;
    public TicTacToe(int n) {
        rows=new int[n];
        cols=new int[n];
        diag=0;
        anti=0;
    }
    
    public int move(int row, int col, int player) {
        int n=rows.length;
        int curr_player=player==1?1:-1;
        rows[row]+=curr_player;
        cols[col]+=curr_player;
        if(row==col){
            diag+=curr_player;
        }
        if(row==rows.length-col-1){
            anti+=curr_player;
        }

        if(Math.abs(rows[row])==n||Math.abs(cols[col])==n||Math.abs(diag)==n||Math.abs(anti)==n){
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