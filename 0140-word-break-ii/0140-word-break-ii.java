class Solution {
    List<String> ans=new ArrayList<>();
    public void f(int ind,String s,String pal,Set<String> set){
        if(ind>=s.length()){
            ans.add(pal.trim());
            return;
        }
        
        for(int i=ind+1;i<=s.length();i++){
            String temp=s.substring(ind,i);
            if(set.contains(temp)){
                f(i,s,pal+temp+" ",set);
            }
        }
    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> set=new HashSet<>(wordDict);
        f(0,s,"",set);
        return ans;
    }
}