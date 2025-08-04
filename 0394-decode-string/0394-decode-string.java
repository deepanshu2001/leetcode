class Solution {
    public String decodeString(String s) {
        Stack<Integer> num_stack=new Stack<>();
        Stack<StringBuilder> st=new Stack<>();
        int curr_No=0;
        StringBuilder curr_str=new StringBuilder();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                curr_No=curr_No*10+ch-'0';
            }
            else if(ch==']'){
               int prev_No=num_stack.pop();
               StringBuilder prev=curr_str;
               curr_str=st.pop();
               while(prev_No>0){
                   prev_No--;
                   curr_str.append(prev);
               }
            }
            else if(ch=='['){
               num_stack.push(curr_No);
               st.push(curr_str);
               curr_No=0;
               curr_str=new StringBuilder();
            }
            else{
                curr_str.append(ch);
            }
        }
        return curr_str.toString();
    }
}