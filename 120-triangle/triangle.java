class Solution {
    public int f(int row,int col,List<List<Integer>> triangle,int dp[][]){
        if(row==triangle.size()-1){
            return triangle.get(row).get(col);
        }
        if(dp[row][col]!=-1){
            return dp[row][col];
        }
        int one=triangle.get(row).get(col)+f(row+1,col,triangle,dp);
        int two=triangle.get(row).get(col)+f(row+1,col+1,triangle,dp);
        return dp[row][col]=Math.min(one,two);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int m=triangle.get(n-1).size();
        int dp[][]=new int[n+1][m+1];
        for(int i=0;i<m;i++){
            dp[n-1][i]=triangle.get(n-1).get(i);
        }
        for(int i=n-1;i>=0;i--){
            for(int j=0;j<triangle.get(i).size();j++){
                int one=triangle.get(i).get(j)+dp[i+1][j];
                int two=triangle.get(i).get(j)+dp[i+1][j+1];
                dp[i][j]=Math.min(one,two);
            }
        }
        return dp[0][0];
    }
}