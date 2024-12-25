class Solution {
    public boolean f(int ind,String s,Set<String> set,Boolean dp[]){
        if(ind>=s.length()){
            return true;
        }
        if(set.contains(s)){
            return true;
        }
        if(dp[ind]!=null){
            return dp[ind];
        }
        for(int i=ind+1;i<=s.length();i++){
            String temp=s.substring(ind,i);
            if(set.contains(temp) && f(i,s,set,dp)){
                dp[ind]=true;
                return true;
            }
        }
        return dp[ind]=false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        Boolean dp[]=new Boolean[s.length()];
        return f(0,s,set,dp);

    }
}