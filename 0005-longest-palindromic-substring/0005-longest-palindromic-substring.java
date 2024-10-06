class Solution {
    public boolean isPalin(String s){
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)==s.charAt(j)){
               i++;
               j--;
            }
            else{
                return false;
            }
        }
        return true;
    }
    public String longestPalindrome(String s) {
        int maxL=1;
        String maxAns=s.substring(0,1);
        for(int i=0;i<s.length();i++){
            for(int j=i+maxL;j<=s.length();j++){
                if(j-i>maxL && isPalin(s.substring(i,j))){
                    maxL=j-i;
                    maxAns=s.substring(i,j);
                }
            }
        }
        return maxAns;
    }
}