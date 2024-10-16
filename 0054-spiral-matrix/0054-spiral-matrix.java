class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        List<Integer> ans=new ArrayList<>();

        int top=0;
        int left=0;
        int bottom=n-1;
        int right=m-1;
        while(top<=bottom && left<=right){
            int i=left;
            while(i<=right){
              ans.add(matrix[top][i]);
              i++;
            }
            top++;
            i=top;
            while(i<=bottom){
                ans.add(matrix[i][right]);
                i++;
            }
            right--;
            i=right;
            if(top<=bottom){
                while(i>=left){
                ans.add(matrix[bottom][i]);
                i--;
            }
            }
           
            bottom--;
            i=bottom;
            if(left<=right){
               while(i>=top){
                ans.add(matrix[i][left]);
                i--;
            }
            }
            
            left++;
        }
    return ans;
    }
}