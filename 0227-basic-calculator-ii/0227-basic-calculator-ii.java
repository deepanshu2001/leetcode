class Solution {
    public int calculate(String s) {
       Stack<Integer> st=new Stack<>();
       int i=0;
       char op='+';
       while(i<s.length()){
         char ch=s.charAt(i);
         if(Character.isDigit(ch)){
            int num=0;
            while(i<s.length() && Character.isDigit(s.charAt(i))){
                num=num*10+s.charAt(i)-'0';
                i++;
            }
            if(op=='+'){
                st.push(num);
            }
            else if(op=='-'){
                st.push(-num);
            }
            else if(op=='*'){
                st.push(st.pop()*num);
            }
            else if(op=='/'){
                st.push(st.pop()/num);
            }
         }
         else{
            if(ch=='+'){
                op='+';
            }
            else if(ch=='-'){
                op='-';
            }
            else if(ch=='/'){
                op='/';
            }
            else if(ch=='*'){
                op='*';
            }
            i++;
         }
       }  
       int ans=0;
       while(!st.isEmpty()){
        ans+=st.pop();
       }
       return ans;
    } 
}