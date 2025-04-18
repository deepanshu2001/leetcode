class Solution {
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        String s="1";
        for(int i=2;i<=n;i++){
            String str="";
            int j=0;
            int cnt=1;
            while(j<s.length()){
              if(j+1<s.length() && s.charAt(j)==s.charAt(j+1)){
                cnt++;
                j++;
              }
              else{
                str+=cnt;
                str+=s.charAt(j);
                cnt=1;
                j++;
              }
            }
            s=new String(str);
        }
        return s;
    }
}