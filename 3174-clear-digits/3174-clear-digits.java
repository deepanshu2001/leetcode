class Solution {
    public String clearDigits(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(Character.isDigit(ch) && !st.isEmpty()){
                st.pop();
            }
            else if(Character.isAlphabetic(ch)){
                st.push(ch);
            }
            else{
                st.push(ch);
                break;
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}