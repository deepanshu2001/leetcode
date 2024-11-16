class Solution {
    public String f(int n){
        if(n==1){
            return "1";
        }
        String s=f(n-1);
        int i=0;
       
        StringBuilder sb=new StringBuilder();
        int j=i+1;
        while(i<s.length()){
        int cnt=1;
        while(j<s.length() && s.charAt(i)==s.charAt(j)){
            cnt++;
            j++;
        }
        sb.append(cnt);
        sb.append(s.charAt(i));
        i=j;
        }
       return sb.toString();

    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        return f(n);
    }
}