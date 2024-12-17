class TicTacToe {
    int rows[];
    int cols[];
    int left_dig;
    int right_diag;
    public TicTacToe(int n) {
        rows=new int[n];
        cols=new int[n];
        left_dig=0;
        right_diag=0;
    }
    
    public int move(int row, int col, int player) {
        int currentplayer=player==1?1:-1;
        int n=rows.length;
        rows[row]+=currentplayer;
        cols[col]+=currentplayer;
        //if consists of left digonal
        if(row==col){
          left_dig+=currentplayer;
        }
        //consist of right digonal
        if(col==cols.length-row-1){
            right_diag+=currentplayer;
        }
        if(Math.abs(rows[row])==n||Math.abs(cols[col])==n||Math.abs(left_dig)==n||Math.abs(right_diag)==n){
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