class Solution {
    class Pair{
        Character first;
        int second;
        public Pair(Character first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(s.charAt(0),1));
        for(int i=1;i<s.length();i++){
            char ch=s.charAt(i);
            if(st.isEmpty()){
                st.push(new Pair(ch,1));
                continue;
            }
           
            Pair pair=st.pop();
            if(pair.first!=ch){
                st.push(pair);
                st.push(new Pair(ch,1));
            }
            else if(pair.first==ch){
                if(pair.second==k-1){
                    continue;
                }
                else{
                    pair.second=pair.second+1;
                    st.push(pair);
                }
            }
        }
        StringBuilder ans=new StringBuilder();;
        while(!st.isEmpty()){
            Pair pair=st.pop();
            char ch=pair.first;
            int cnt=pair.second;
            while(cnt!=0){
                cnt--;
                ans.append(ch);
            }
        }
        return ans.reverse().toString();
    }
}