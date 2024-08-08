class Solution {
    public int[][] generateMatrix(int n) {
        List<Integer> list=new ArrayList<>();
        int cnt=1;
        int top=0;
        int left=0;
        int matrix[][]=new int[n][n];
        int right=n-1;
        int bottom=n-1;
        while(left<=right && top<=bottom){
           //top
           for(int i=left;i<=right;i++){
            matrix[top][i]=cnt;
            cnt++;
           }
           top++;
           //right
           for(int i=top;i<=bottom;i++){
            matrix[i][right]=cnt;
            cnt++;
           }
           right--;
           //bottom
           if(top<=bottom){
            for(int i=right;i>=left;i--){
                matrix[bottom][i]=cnt;
                cnt++;
            }
           }
           bottom--;
           //left
           if(left<=right){
              for(int i=bottom;i>=top;i--){
                matrix[i][left]=cnt;
                cnt++;
              }
           }
           left++;
        }
        return matrix;
    }
}