class TicTacToe {
    int arr[][];
    public TicTacToe(int n) {
        arr=new int[n][n];
    }
    
    public int move(int row, int col, int player) {
        arr[row][col]=player;
        int n=arr.length;
        //check row 
        boolean row_flag=true;
        for(int i=0;i<arr.length;i++){
            if(arr[row][i]!=player){
                row_flag=false;
                break;
            }
        }
        boolean col_flag=true;
        for(int i=0;i<n;i++){
            if(arr[i][col]!=player){
                col_flag=false;
                break;
            }
        }
        boolean diag=true;
        for(int i=0;i<n;i++){
            if(arr[i][i]!=player){
                diag=false;
                break;
            }
        }
        boolean antidiag=true;
        int row_con=0;
        for(int i=n-1;i>=0;i--){
            if(arr[row_con][i]!=player){
                antidiag=false;
                break;
            }
            row_con++;
        }
        if(row_flag||col_flag||diag||antidiag){
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