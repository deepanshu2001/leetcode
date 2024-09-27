class Solution {
    public int f(int index,int row,List<List<Integer>> triangle,int dp[][]){
        int n=triangle.size();
        if(dp[index][row]!=-1){
            return dp[index][row];
        }
        if(row==n-1){
            return dp[index][row]=triangle.get(row).get(index);
        }
        
        int first=triangle.get(row).get(index)+f(index,row+1,triangle,dp);
        int second=triangle.get(row).get(index)+f(index+1,row+1,triangle,dp);
        return dp[index][row]=Math.min(first,second);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,0,triangle,dp);
    }
}