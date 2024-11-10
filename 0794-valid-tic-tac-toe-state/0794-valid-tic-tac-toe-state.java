class Solution {
    public boolean validTicTacToe(String[] board) {
       if(board[0].charAt(0)=='O'){
        return false;
       }
       for(int i=0;i<board.length;i++){
        if(!board[i].contains("X")||!board[i].contains("0")){
            return false;
        }
        if(board[i].equals("XXX")||board[i].equals("OOO")){
            return false;
        }
        
       }
       return true;
    }
}