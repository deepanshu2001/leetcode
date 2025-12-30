class Solution {
    int ans=0;
    public int maximumGain(String s, int x, int y) {
        String highP=x>y?"ab":"ba";
        String lowP=highP=="ab"?"ba":"ab";
        int high=highP=="ab"?x:y;
        int low=high==x?y:x;
        //firstpass
        String str=removeString(s,highP,high);
        String final_str=removeString(str,lowP,low);
        return ans;
    }
    public String removeString(String s,String str,int score){
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(!st.isEmpty() && ch==str.charAt(1) && st.peek()==str.charAt(0)){
                st.pop();
                ans+=score;
            }
            else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }
        return sb.reverse().toString();
    }
}