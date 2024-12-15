class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s=strs[0];
        String ans="";
        for(int i=1;i<strs.length;i++){
           while(s.length()!=0 && strs[i].indexOf(s)==-1){
            s=s.substring(0,s.length()-1);
           }
           ans=s;
           
        }
        return ans;
    }
}