class Solution {
    List<String> ans=new ArrayList<>();
    public void f(int l,int r,int n,String s){
        if(l==n && r==n){
            ans.add(s);
            return;
        }
        //left
        if(l<n){
            f(l+1,r,n,s+'(');
        }
        if(l>r){
            f(l,r+1,n,s+')');
        }
    }
    public List<String> generateParenthesis(int n) {
       f(0,0,n,"");     
       return ans;
    }
}