class Solution {
    public int f(int ind1,int ind2,int nums1[],int nums2[],int dp[][]){
        if(ind1<0||ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(nums1[ind1]==nums2[ind2]){
            return dp[ind1][ind2]= 1+f(ind1-1,ind2-1,nums1,nums2,dp);
        }
        return dp[ind1][ind2]=Math.max(f(ind1-1,ind2,nums1,nums2,dp),f(ind1,ind2-1,nums1,nums2,dp));
    }
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        int dp[][]=new int[n+1][m+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(nums1[i-1]==nums2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }
        }
        return dp[n][m];
    }
}