class Solution {
    public int f(int i,int j,List<List<Integer>> triangle,int n,int dp[][]){
        if(i==n-1){
            return dp[i][j]=triangle.get(i).get(j);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=triangle.get(i).get(j)+f(i+1,j,triangle,n,dp);
        int diagonal=triangle.get(i).get(j)+f(i+1,j+1,triangle,n,dp);
        return dp[i][j]=Math.min(down,diagonal);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,triangle,n,dp);
    }
}