class Solution {
    public boolean check(String []board,char player){
        //checking for row and col
        for(int i=0;i<board.length;i++){
            if(board[i].charAt(0)==player && board[i].charAt(1)==player && board[i].charAt(2)==player){
                return true;
            }
            if(board[0].charAt(i)==player && board[1].charAt(i)==player && board[2].charAt(i)==player){
                return true;
            }
        }
        //checking diagonals
        if(board[0].charAt(0)==player && board[1].charAt(1)==player && board[2].charAt(2)==player){
            return true;
        }
        if(board[0].charAt(2)==player && board[1].charAt(1)==player && board[2].charAt(0)==player){
            return true;
        }
        return false;
    }
    public boolean validTicTacToe(String[] board) {
        int x_count=0;
        int o_count=0;
        for(int i=0;i<board.length;i++){
            if(board[i].charAt(0)=='X'){
                x_count++;
            }
            if(board[i].charAt(1)=='X'){
                x_count++;
            }
            if(board[i].charAt(2)=='X'){
                x_count++;
            }
            if(board[i].charAt(0)=='O'){
                o_count++;
            }
            if(board[i].charAt(1)=='O'){
                o_count++;
            }
            if(board[i].charAt(2)=='O'){
                o_count++;
            }

        }
        if(o_count>x_count||x_count>o_count+1){
            return false;
        }
        boolean x_wins=check(board,'X');
        boolean o_wins=check(board,'O');
        if(x_wins && o_wins){
            return false;
        }
        if(x_wins && x_count!=o_count+1){
            return false;
        }
        if(o_wins && o_count!=x_count){
            return false;
        }
        return true;
    }
}