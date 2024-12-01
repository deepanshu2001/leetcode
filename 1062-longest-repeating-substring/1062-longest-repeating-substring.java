class Solution {
    public int longestRepeatingSubstring(String s) {
        int ans=0;
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                String new_string=s.substring(i,j+1);
                if(set.contains(new_string)){
                    ans=Math.max(ans,new_string.length());
                }
                else{
                    set.add(new_string);
                }
            }
        }
        return ans;
    }
}