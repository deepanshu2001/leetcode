class Solution {
    public String simplifyPath(String path) {
        Stack<String> st=new Stack<>();
        String str[]=path.split("/");
        for(String s:str){
            if(s.equals(".")||s.isEmpty()){
                continue;
            }
            else if(s.equals("..")){
                if(!st.isEmpty()){
                    st.pop();
                }
            }
            else{
                st.push(s);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(String dir:st){
            sb.append("/");
            sb.append(dir);
        }
        return sb.length()>0?sb.toString():"/";
    }
}