class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.equals("+")||s.equals("-")||s.equals("*")||s.equals("/")){
                int elem1=st.pop();
                int elem2=st.pop();
                if(s.equals("+")){
                    st.push(elem2+elem1);
                }
                else if(s.equals("-")){
                    st.push(elem2-elem1);
                }
                else if(s.equals("*")){
                    st.push(elem2*elem1);
                }
                else{
                    st.push(elem2/elem1);
                }
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.peek();
    }
}