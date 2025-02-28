class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length()!=s2.length()){
            return false;
        }
        if(s1.equals(s2)){
            return true;
        }
        char ch1[]=new char[26];
        char ch2[]=new char[26];
        int diff=0;
        for(int i=0;i<s1.length();i++){
            char c1=s1.charAt(i);
            char c2=s2.charAt(i);
            if(c1!=c2){
               diff++;
               if(diff>2){
                return false;
               }
            }
            ch1[c1-'a']++;
            ch2[c2-'a']++;
        }
        return Arrays.equals(ch1,ch2);
              
    }
}