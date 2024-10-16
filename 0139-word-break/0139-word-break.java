class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        for(String str:wordDict){
            if(s.contains(str)==false){
                return false;
            }
            else{
                int ind=s.indexOf(str);
                int len=str.length();
                s=s.substring(0,ind)+s.substring(len,s.length());
            }
        }
        return true;
    }
}