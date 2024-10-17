class Solution {
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int ans[][]=new int[matrix.length][matrix.length];
        int row=0;
        int col=n-1;
        for(int i=0;i<n;i++){
            row=0;
            for(int j=0;j<n;j++){
               ans[row][col]=matrix[i][j];
               row++;
            }
            col--;
            
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]=ans[i][j];
            }
        }
    }
}