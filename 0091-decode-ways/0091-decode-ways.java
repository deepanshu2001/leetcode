class Solution {
    public int f(int ind,String s){
        if(ind==s.length()){
            return 1;
        }
        if(s.charAt(ind)=='0'){
            return 0;
        }
        int ways=f(ind+1,s);
        if(ind+1<s.length() && Integer.parseInt(s.substring(ind,ind+2))<=26){
            ways+=f(ind+2,s);
        }
        return ways;
    }
    public int numDecodings(String s) {
        if(s.charAt(0)=='0'){
            return 0;
        }
        return f(0,s);
    }
}