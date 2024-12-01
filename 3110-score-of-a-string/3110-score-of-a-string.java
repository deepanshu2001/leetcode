class Solution {
    public int scoreOfString(String s) {
        int ans=0;
        for(int i=0;i<s.length()-1;i++){
            int ch1=s.charAt(i)-'0';
            int ch2=s.charAt(i+1)-'0';
            ans+=Math.abs(ch1-ch2);
        }
        return ans;
    }
}