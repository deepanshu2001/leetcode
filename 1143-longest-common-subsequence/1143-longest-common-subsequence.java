class Solution {
    public int f(String text1,String text2,int ind1,int ind2,int dp[][]){
        if(ind1<0||ind2<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        if(text1.charAt(ind1)==text2.charAt(ind2)){
            return dp[ind1][ind2]=1+f(text1,text2,ind1-1,ind2-1,dp);
        }
        return dp[ind1][ind2]=Math.max(f(text1,text2,ind1-1,ind2,dp),f(text1,text2,ind1,ind2-1,dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int dp[][]=new int[text1.length()][text2.length()];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(text1,text2,text1.length()-1,text2.length()-1,dp);
    }
}