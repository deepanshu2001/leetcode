class Solution {
    public void reverse(int i,int j,int []arr){
        while(i<j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        //transpose the matrix
        for(int i=0;i<n;i++){
            for(int j=i;j<m;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
        //reverse each row
        
        for(int row[]:matrix){
            reverse(0,m-1,row);
        }
    }
}