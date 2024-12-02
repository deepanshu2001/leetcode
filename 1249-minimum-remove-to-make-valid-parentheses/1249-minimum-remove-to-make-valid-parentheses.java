class Solution {
    class Pair{
        int num;
        char ch;
        Pair(int num,char ch){
            this.num=num;
            this.ch=ch;
        }
    }
    public String minRemoveToMakeValid(String s) {
        Stack<Pair> st=new Stack<>();
        for(int i=s.length()-1;i>=0;i--){
            char cha=s.charAt(i);
            if(cha=='('||cha==')'){
                if(cha==')' ||st.isEmpty()){
                    st.push(new Pair(i,cha));
                }
                else if(!st.isEmpty() && cha=='('){
                    if(st.peek().ch==')'){
                        st.pop();
                    }
                   else{
                    st.push(new Pair(i,cha));
                   }
                }
            }
        }
        String ans="";
        Set<String> set=new HashSet<>();
        while(!st.isEmpty()){
           set.add(st.peek().num+","+st.peek().ch);
           st.pop();
        }
        for(int i=0;i<s.length();i++){
            char cha=s.charAt(i);
            if(cha=='('||cha==')'){
              if(set.contains(i+","+cha)){
                continue;
              }
              else{
                ans+=cha;
              }
            }
            else{
                ans+=cha;
            }
        }
        return ans;
    }
}