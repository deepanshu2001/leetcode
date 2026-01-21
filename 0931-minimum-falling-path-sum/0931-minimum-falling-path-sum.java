class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int ans=(int)1e9;
        int dp[][]=new int[n][n];
        for(int i=0;i<n;i++){
            dp[n-1][i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int bt=matrix[i][j]+dp[i+1][j];
                int ld=matrix[i][j];
                if(j-1>=0){
                    ld+=dp[i+1][j-1];
                }
                else{
                    ld+=(int)1e9;
                }
                int rd=matrix[i][j];
                if(j+1<n){
                    rd+=dp[i+1][j+1];
                }
                else{
                    rd+=(int)1e9;
                }
                dp[i][j]=Math.min(bt,Math.min(ld,rd));
            }
        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,dp[0][i]);
        }
        return ans;
    }
}