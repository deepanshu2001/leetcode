class Solution {
    public int f(int ind,String s,int dp[]){
        if(ind==s.length()){
            return dp[ind]=1;
        }
        if(s.charAt(ind)=='0'){
            return dp[ind]=0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int ways=f(ind+1,s,dp);
        if(ind+1<s.length() && Integer.parseInt(s.substring(ind,ind+2))<=26){
            ways+=f(ind+2,s,dp);
        }
        return dp[ind]=ways;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        int dp[]=new int[s.length()+1];
        Arrays.fill(dp,-1);
        return f(0,s,dp);
    }
}