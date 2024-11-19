class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int ans[]=new int[n];
        int last_log=-1;
        Stack<Integer> st=new Stack<>();
        for(String strs:logs){
            String s[]=strs.split(":");
            int funcId=Integer.parseInt(s[0]);
            String call=s[1];
            int timeStamp=Integer.parseInt(s[2]);
            if(!call.equals("start")){
                timeStamp++;
            }
            if(!st.isEmpty()){
                int id=st.peek();
                ans[id]+=timeStamp-last_log;
            }
            if(call.equals("start")){
                st.push(funcId);
            }
            else{
                st.pop();
            }
            last_log=timeStamp;
        }
        return ans;
    }
}