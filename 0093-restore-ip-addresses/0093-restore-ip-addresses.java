class Solution {
    public void solve(List<String> ans,String str,String s,int ind,int cnt){
        if(cnt==4 && ind==s.length()){
            ans.add(str.substring(0,str.length()-1));
            return;
        }
        if(cnt==4 && ind!=s.length()){
            return;
        }
        for(int i=ind;i<s.length() && i<ind+3;i++){
            String new_str=s.substring(ind,i+1);
            if(valid(new_str)){
               solve(ans,str+new_str+".",s,i+1,cnt+1);
            }
        }
    }
    public boolean valid(String s){
        if(s.length()==0){
            return false;
        }
        if(s.length()>1 && s.charAt(0)=='0'){
            return false;
        }
        int num=Integer.parseInt(s);
        if(num>=0 && num<=255){
            return true;
        }
        return false;
    }
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        if(s.length()<4||s.length()>12){
            return ans;
        }
        solve(ans,"",s,0,0);
        return ans;
    }
}