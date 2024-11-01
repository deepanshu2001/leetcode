class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxMatrix=0;
        int n=matrix.length;
        int m=matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]=='1'){
                    int curr_Size=1;
                    boolean is_square=true;
                    while(i+curr_Size<n && j+curr_Size<m && is_square){
                        for(int k=0;k<=curr_Size;k++){
                            if(matrix[i+k][j+curr_Size]=='0'||matrix[i+curr_Size][j+k]=='0'){
                                is_square=false;
                                break;
                            }
                        }
                        if(is_square){
                            curr_Size++;
                        }
                    }
                    maxMatrix=Math.max(curr_Size,maxMatrix);

                }
                
            }
        }
        return maxMatrix*maxMatrix;
    }
}