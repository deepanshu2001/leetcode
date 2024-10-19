


class Solution {
    public boolean solve(String s,String p,Boolean dp[][],int i,int j){
        //base case
        if(j==p.length()){
            return s.length()==i;
        }
        if(dp[i][j]!=null){
            return dp[i][j];
        }
        boolean flag=false;
        if(i<s.length() && (s.charAt(i)==p.charAt(j)||p.charAt(j)=='.')){
            flag=true;
        }
        if(j+1<p.length() && p.charAt(j+1)=='*'){
            boolean notake=solve(s,p,dp,i,j+2);
            boolean take=flag && solve(s,p,dp,i+1,j);
            return take||notake;
        }
        else{
            return flag && solve(s,p,dp,i+1,j+1);
        }
    }
    public boolean isMatch(String s, String p) {
        Boolean dp[][]=new Boolean[s.length()+1][p.length()+1];
        
        return solve(s,p,dp,0,0);
    }
}