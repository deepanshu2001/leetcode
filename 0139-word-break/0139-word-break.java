class Solution {
    int memo[];
    String s="";
    List<String> wordDict;
    public boolean f(int i){
        if(i<0){
            return true;
        }
        if(memo[i]!=-1){
            return memo[i]==1;
        }
        for(String word:wordDict){
            if(i-word.length()+1<0){
                continue;
            }
            if(word.equals(s.substring(i-word.length()+1,i+1)) && f(i-word.length())){
                memo[i]=1;
                return true;

            }
        }
        memo[i]=0;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        this.s=s;
        this.wordDict=wordDict;
        this.memo=new int[s.length()];
        Arrays.fill(memo,-1);
        return f(s.length()-1);
    }
}