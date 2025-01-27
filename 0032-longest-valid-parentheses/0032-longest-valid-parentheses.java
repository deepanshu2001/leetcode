class Solution {
    public int longestValidParentheses(String s) {
        if(s.isEmpty()){
            return 0;
        }
        Stack<Character> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(ch);
                continue;
            }
            if(ch=='(' && st.peek()==')'){
                st.pop();
            }
            else if(ch=='(' && st.peek()=='('){
                st.push(ch);
            }
            else if(ch==')'){
                st.push(ch);
            }
        }
        return s.length()-st.size();
    }
}