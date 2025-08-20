class Solution {
   
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>();
        for(int i=0;i<wordDict.size();i++){
            set.add(wordDict.get(i));
        }
        boolean dp[]=new boolean[s.length()+1];
        int n=s.length();
        dp[n]=true;
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                String temp=s.substring(i,j);
                if(set.contains(temp) && dp[j]){
                    dp[i]=true;
                    
                }
            }
        }

        return dp[0];

    }
}