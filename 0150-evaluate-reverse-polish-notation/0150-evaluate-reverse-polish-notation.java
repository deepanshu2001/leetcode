class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int v1=st.pop();
                int v2=st.pop();
                if(s.equals("+")){
                    st.push(v2+v1);
                }
                else if(s.equals("-")){
                    st.push(v2-v1);
                }
                else if(s.equals("*")){
                    st.push(v2*v1);
                }
                else{
                    st.push(v2/v1);
                }
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}