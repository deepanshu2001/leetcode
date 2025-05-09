class Solution {
    public boolean helper(String s,String p,int i,int j,Boolean dp[][]){
        if(j==p.length()){
            return i==s.length();
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean flag=(i<s.length()&&(s.charAt(i)==p.charAt(j)||p.charAt(j)=='.'));
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean nottake=helper(s,p,i,j+2,dp);
            boolean take=flag && helper(s,p,i+1,j,dp);
            dp[i][j]=take||nottake;
        }
        else{
            dp[i][j]=flag && helper(s, p,i+1,j+1,dp);
        }
        return dp[i][j];
    }
    public boolean isMatch(String s, String p) {
        Boolean dp[][]=new Boolean[s.length()+1][p.length()+1];
        return helper(s,p,0,0,dp);
    }
}