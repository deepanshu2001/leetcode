class Solution {
    public void reverse(int []arr){
        int i=0;
        int j=arr.length-1;
        while(i<=j){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
       for(int i=0;i<n;i++){
        for(int j=i;j<n;j++){
            int a=matrix[i][j];
            int b=matrix[j][i];
            matrix[i][j]=b;
            matrix[j][i]=a;
        }
       }
       for(int arr[]:matrix){
        reverse(arr);
       }   
    }
}