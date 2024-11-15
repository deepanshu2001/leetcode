class Solution {
    public int minLength(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)!='B' && s.charAt(i)!='D'){
                st.push(s.charAt(i));
            }
            else{
                if(st.isEmpty()){
                    st.push(s.charAt(i));
                    continue;
                }
                if(s.charAt(i)=='B'){
                    if(st.peek()=='A'){
                        st.pop();
                    }
                    else{
                        st.push(s.charAt(i));
                    }
                }
                if(s.charAt(i)=='D'){
                    if(st.peek()=='C'){
                        st.pop();
                    }
                    else{
                        st.push(s.charAt(i));
                    }
                }
            }
        }
        return st.size();
    }
}