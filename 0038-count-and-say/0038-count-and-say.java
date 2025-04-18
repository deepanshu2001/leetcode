class Solution {
    public String f(int n){
        if(n==1){
            return "1";
        }
        String s=f(n-1);
        String str="";
        int i=0;
        int cnt=1;
        while(i<s.length()){
            if(i+1<s.length() && s.charAt(i)==s.charAt(i+1)){
                cnt++;
                i++;
            }
            else{
                str+=cnt;
                str+=s.charAt(i);
                cnt=1;
                i++;
            }
        }
        return str;
    }
    public String countAndSay(int n) {
        return f(n);
    }
}