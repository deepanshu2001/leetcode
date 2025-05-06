class Solution {
    public String center(int i,int j,String s){
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
    public String longestPalindrome(String s) {
        //expanding and checking from center instead of corners
        String ans=s.substring(0,1);
        for(int i=0;i<s.length()-1;i++){
            String odd=center(i,i,s);
            String even=center(i,i+1,s);
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