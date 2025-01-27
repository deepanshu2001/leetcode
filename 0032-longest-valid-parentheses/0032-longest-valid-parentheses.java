class Solution {
    public int longestValidParentheses(String s) {
        int l=0;
        int r=0;
        int ans=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='('){
                l++;
            }
            else{
                r++;
            }
            if(l==r){
                ans=Math.max(ans,2*l);
            }
            if(r>l){
                l=0;
                r=0;
            }
        }
        //reverse
        l=0;
        r=0;
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch=='('){
                l++;
            }
            else{
                r++;
            }
            if(l==r){
                ans=Math.max(ans,2*l);
            }
            if(l>r){
                l=0;
                r=0;
            }
        }
        return ans;
    }
}