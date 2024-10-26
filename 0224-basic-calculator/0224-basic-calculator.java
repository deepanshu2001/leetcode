class Solution {
    public int calculate(String s) {
        
        int sign=1;
        int ans=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch)){
                int num=ch-'0';
                while(i+1<s.length()&&Character.isDigit(s.charAt(i+1))){
                    num=num*10+s.charAt(i+1)-'0';
                    i++;
                }
                ans+=num*sign;
            }
            else if(ch=='+'){
                sign=1;
            }
            else if(ch=='-'){
                sign=-1;
            }
            else if(ch=='('){
                st.push(ans);
                st.push(sign);
                ans=0;
                sign=1;
            }
            else if(ch==')'){
                ans=ans*st.pop()+st.pop();
            }
        }
        return ans;
    }
}