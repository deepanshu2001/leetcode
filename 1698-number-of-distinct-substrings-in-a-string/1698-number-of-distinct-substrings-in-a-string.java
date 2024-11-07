

class Solution {
    int cnt=0;
    class Node{
        Node links[];
        public Node(){
            links=new Node[26];
        } 
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public Node get(char ch){
            return links[ch-'a'];
        }
        public void put(char ch,Node node){
            links[ch-'a']=node;
        }
}

    public int countDistinct(String s) {
        Node root=new Node();
        int cnt=0;
        for(int i=0;i<s.length();i++){
            Node node=root;
            for(int j=i;j<s.length();j++){
                char ch=s.charAt(j);
                if(!node.containsKey(ch)){
                    cnt++;
                    node.put(ch,new Node());
                }
                node=node.get(ch);
            }
        }
        return cnt;
    }
}