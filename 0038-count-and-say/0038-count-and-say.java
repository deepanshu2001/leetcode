class Solution {
    StringBuilder ans=new StringBuilder();
    public void f(int n){
        if(n==2){
            ans.append("11");
            return;
        }
        f(n-1);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<ans.length();i++){
            int j=i;
            int cnt=0;
            while(j<ans.length() && ans.charAt(i)==ans.charAt(j)){
                cnt++;
                j++;
            }
            i=j-1;
            sb.append(cnt);
            sb.append(ans.charAt(i));
        }
        ans.delete(0,ans.length());
        ans.append(sb);
    }
    public String countAndSay(int n) {
        if(n==1){
            return "1";
        }
        f(n);
        return ans.toString();
    }
}