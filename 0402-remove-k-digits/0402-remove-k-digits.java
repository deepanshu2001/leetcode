class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Integer> st=new Stack<>();
        int cnt=0;
        if(num.length()==k){
            return "0";
        }
        for(int i=0;i<num.length();i++){
            char ch=num.charAt(i);
            int n=ch-'0';
            while(!st.isEmpty() && cnt<k && n<st.peek()){
                st.pop();
                cnt++;
            }
            st.push(n);
        }
        while(!st.isEmpty() && cnt<k){
            st.pop();
            cnt++;
        }
        if(st.isEmpty()){
            return "0";
        }
        StringBuilder sb=new StringBuilder();
        for(int n:st){
            sb.append(n);
        }
        String ans=sb.toString();
        if(ans.charAt(0)=='0' && ans.length()>1){
            return ans.substring(1);
        }
        return ans;
    }
}