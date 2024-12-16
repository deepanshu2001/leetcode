class Solution {
    public void f(List<String> ans,int n,int left_count,int right_count,String curString){
        if(curString.length()==2*n){
            ans.add(curString);
            return;
        }
        if(left_count<n){
            curString+="(";
            f(ans,n,left_count+1,right_count,curString);
            curString=curString.substring(0,curString.length()-1);
        }
        if(left_count>right_count){
            curString+=")";
            f(ans,n,left_count,right_count+1,curString);
            curString=curString.substring(0,curString.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        f(ans,n,0,0,"");
        return ans;
    }
}