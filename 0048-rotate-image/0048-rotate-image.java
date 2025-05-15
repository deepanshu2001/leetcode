class Solution {
    public void reverse(int arr[],int i,int j){
        while(i<j){
            int temp1=arr[i];
            int temp2=arr[j];
            arr[i]=temp2;
            arr[j]=temp1;
            i++;
            j--;
        }
    }
    public void rotate(int[][] matrix) {
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                int num1=matrix[i][j];
                int num2=matrix[j][i];
                matrix[i][j]=num2;
                matrix[j][i]=num1;
            }
        }
        for(int arr[]:matrix){
            reverse(arr,0,arr.length-1);
        }
        
    }
}