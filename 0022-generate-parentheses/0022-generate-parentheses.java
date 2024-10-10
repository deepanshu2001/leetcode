class Solution {
    public void f(int open,int close,List<String> ans,String s){
        if(open==0 && close==0){
            ans.add(s);
            return;
        }
        if(open!=0){
            String str=new String(s);
            str+="(";
            f(open-1,close,ans,str);
        }
        if(close>open){
            String str=new String(s);
            str+=")";
            f(open,close-1,ans,str);
        }
    }
    public List<String> generateParenthesis(int n) {
        int open=n;
        int close=n;
        List<String> ans=new ArrayList<>();
        f(open,close,ans,"");
        return ans;
    }
}