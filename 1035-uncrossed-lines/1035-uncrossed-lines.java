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
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(n-1,m-1,nums1,nums2,dp);
    }
}