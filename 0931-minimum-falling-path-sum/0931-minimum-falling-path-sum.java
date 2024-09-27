class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=Integer.MAX_VALUE;
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<n;i++){
            dp[0][i]=matrix[0][i];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int u=matrix[i][j]+dp[i-1][j];
                int left=matrix[i][j];
                if(j>0){
                    left+=dp[i-1][j-1];
                }
                else{
                    left+=(int)Math.pow(10,9);
                }
                int right=matrix[i][j];
                if(j<n-1){
                    right+=dp[i-1][j+1];
                }
                else{
                    right+=(int)Math.pow(10,9);
                }
                dp[i][j]=Math.min(u,Math.min(left,right));
            }
        }
        for(int j=0;j<n;j++){
            ans=Math.min(ans,dp[n-1][j]);
        }
        return ans;
    }
}