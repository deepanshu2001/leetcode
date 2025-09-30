class Solution {
    class Node{
        Node links[]=new Node[10];
        boolean flag=false;
        Node(){

        }
        public boolean containsKey(char ch){
            return links[ch-'0']!=null;
        }
        public void put(char ch,Node node){
            links[ch-'0']=node;
        }
        public Node get(char ch){
            return links[ch-'0'];
        }
        public void setEnd(){
            flag=true;
        }
        public boolean isEnd(){
            return flag==true;
        }
    }
    class Trie{
        Node root;
        Trie(){
            root=new Node();
        }
        public Node getRoot(){
            return root;
        }
        public void insert(String word){
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                }
                node=node.get(ch);
            }
            node.setEnd();
        }
        public int match(String s){
            Node node=root;
            int cnt=0;
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                if(!node.containsKey(ch)){
                    return cnt;
                }
                cnt++;
                node=node.get(ch);

            }
            return cnt;
        }
    }
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Trie t1=new Trie();
        for(int num:arr1){
            String s=String.valueOf(num);
            t1.insert(s);
        }
        int ans=0;
        for(int num:arr2){
            String s=String.valueOf(num);
            ans=Math.max(ans,t1.match(s));
        }
        return ans;
    }
}