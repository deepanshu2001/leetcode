class Solution {
    public String processStr(String s) {
        String ans="";
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='*'){
                if(ans.length()>0){
                    ans=ans.substring(0,ans.length()-1);
                }
            }
            else if(ch=='#'){
                ans=ans+ans;
            }
            else if(ch=='%'){
                String k="";
                for(int j=ans.length()-1;j>=0;j--){
                   k+=ans.charAt(j);
                }
                ans=new String(k);
            }
            else{
                ans+=ch;
            }
        }
        return ans;
    }
}