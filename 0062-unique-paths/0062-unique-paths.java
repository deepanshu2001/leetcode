class Solution {
    public int f(int row,int col){
        if(row==0 && col==0){
            return 1;
        }
        if(row<0||col<0){
            return 0;
        }
        int up=f(row-1,col);
        int left=f(row,col-1);
        return left+up;
    }
    public int uniquePaths(int m, int n) {
        return f(m-1,n-1);
    }
}