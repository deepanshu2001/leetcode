class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<tokens.length;i++){
            String s=tokens[i];
            if(s.equals("+") || s.equals("-")||s.equals("/")||s.equals("*")){
                int num2=st.pop();
                int num1=st.isEmpty()?0:st.pop();
                if(s.equals("+")){
                    st.push(num1+num2);
                }
                if(s.equals("-")){
                    st.push(num1-num2);
                }
                if(s.equals("/")){
                    st.push(num1/num2);
                }
                if(s.equals("*")){
                    st.push(num1*num2);
                }
            }
            else{
                st.push(Integer.parseInt(s));
            }
        }
        return st.pop();
    }
}