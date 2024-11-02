class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st=new Stack<>();
          
        for(int i=s.length()-1;i>=0;i--){
            char ch=s.charAt(i);
            if(ch==')'){
                st.push(')');
            }
            else{
                if(!st.isEmpty() && st.peek()==')'){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
}