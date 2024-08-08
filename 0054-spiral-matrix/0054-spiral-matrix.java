class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans=new ArrayList<>();
        //flow--right->bottom->left->top
        int n=matrix.length;
        int m=matrix[0].length;
        int top=0;
        int left=0;
        int right=m-1;
        int bottom=n-1;
        while(left<=right && top<=bottom){
            //traversal for right
            for(int i=left;i<=right;i++){
                ans.add(matrix[top][i]);
            }
            top++;
            //traversal for bottom
            for(int i=top;i<=bottom;i++){
                ans.add(matrix[i][right]);
            }
            right--;
            if(top<=bottom){

               //traversal for left;
               for(int i=right;i>=left;i--){

                   ans.add(matrix[bottom][i]);
                }
            }
            bottom--;
            if(left<=right){
                //traversal for top
                for(int i=bottom;i>=top;i--){
                   ans.add(matrix[i][left]);
                }
            }
            left++;
        }
        return ans;
    }
}