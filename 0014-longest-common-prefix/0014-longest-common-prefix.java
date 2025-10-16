class Solution {
    class Node{
        Node []links=new Node[26];
        int size=0;
        boolean flag=false;
        Node(){

        }
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public void put(char ch,Node node){
            links[ch-'a']=node;
            size++;
        }
        public Node get(char ch){
            return links[ch-'a'];
        }
        public boolean isEnd(){
            return flag==true;
        }
        public void setEnd(){
            flag=true;
        }
        public int getSize(){
            return size;
        }
    }
    class Trie{
        Node root;
        Trie(){
            root=new Node();
        }
        public void insertWord(String word){
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
        public String containsPrefix(String word){
            StringBuilder prefix=new StringBuilder();
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.containsKey(ch) && node.getSize()==1 && !node.isEnd()){
                    prefix.append(ch);
                    node=node.get(ch);
                }
                else{
                    return prefix.toString();
                }
            }
            return prefix.toString();
        }
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==1){
            return strs[0];
        }
        if(strs.length==0){
            return "";
        }
        Trie trie=new Trie();
        for(int i=1;i<strs.length;i++){
            trie.insertWord(strs[i]);
        }
        return trie.containsPrefix(strs[0]);
    }
}