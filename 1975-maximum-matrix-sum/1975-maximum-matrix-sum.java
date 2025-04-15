class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int neg=0;
        int total_sum=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix.length;j++){
                total_sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    min=Math.min(min,Math.abs(matrix[i][j]));
                    neg++;
                }
            }
        }
        if(neg%2!=0){
            total_sum-=2*min;
        }
        return total_sum;
        
    }
}