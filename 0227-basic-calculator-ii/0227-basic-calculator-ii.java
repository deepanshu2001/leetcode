class Solution {
    public int calculate(String s) {
        Stack<Integer> st=new Stack<>();
        char op='+';
        int num=0;
        int i=0;
        while(i<s.length()){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                num=num*10+ch-'0';
            }
            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {
                if(op=='+'){
                    st.push(num);
                }
                if(op=='-'){
                    st.push(-num);
                }
                if(op=='*'){
                    st.push(st.pop()*num);
                }
                if(op=='/'){
                    st.push(st.pop()/num);
                }
                op=ch;
                num=0;
            }
            i++;
        }
        int ans=0;
        while(!st.isEmpty()){
            ans+=st.pop();
        }
        return ans;
    }
}