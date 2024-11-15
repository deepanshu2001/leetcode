class Solution {
    public long minimumSteps(String s) {
        int cnt = 0;
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
           if(s.charAt(i)=='1'){
            st.push(s.charAt(i));
           }
           else{
            cnt+=st.size();
           }
        }

        return cnt;
    }
}