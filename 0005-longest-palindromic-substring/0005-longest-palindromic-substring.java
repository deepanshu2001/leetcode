class Solution {
    public String center(String s,int i,int j){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
           i--;
           j++;
        }
        return s.substring(i+1,j);
    }
    public String longestPalindrome(String s) {
        String ans=s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            String odd=center(s,i,i);
            String even=center(s,i,i+1);
            if(odd.length()>ans.length()){
                ans=odd;
            }
            if(even.length()>ans.length()){
                ans=even;
            }
        }
        return ans;
    }
}