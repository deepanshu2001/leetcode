class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        char op='+';
        int curr=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
              curr=curr*10+ch-'0';
            }
            if(ch!=' ' && !Character.isDigit(ch) ||i==s.length()-1){
                if(op=='+'){
                    st.push(curr);
                }
                if(op=='-'){
                    st.push(-curr);
                }
                if(op=='*'){
                    st.push(st.pop()*curr);
                }
                if(op=='/'){
                    st.push(st.pop()/curr);
                }
                curr=0;
                op=ch;
            }

        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}