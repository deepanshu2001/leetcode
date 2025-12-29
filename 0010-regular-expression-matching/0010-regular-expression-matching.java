class Solution {
    public boolean solve(String s,String p){
        //base case
        if(p.length()==0){
            return s.length()==0;
        }
        boolean flag=false;
        if(s.length()>0 && (s.charAt(0)==p.charAt(0)||p.charAt(0)=='.')){
            flag=true;
        }
        if(p.length()>1 && p.charAt(1)=='*'){
            boolean notake=solve(s,p.substring(2));
            boolean take=flag && solve(s.substring(1),p);
            return take||notake;
        }
        else{
            return flag && solve(s.substring(1),p.substring(1));
        }
    }
    public boolean isMatch(String s, String p) {
        return solve(s,p);
    }
}