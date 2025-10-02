class Solution {
    class Node{
        Node links[]=new Node[26];
        boolean flag=false;
        Node(){

        }
        public boolean containsKey(char ch){
            return links[ch-'a']!=null;
        }
        public void put(char ch,Node node){
            links[ch-'a']=node;
        }
        public Node get(char ch){
            return links[ch-'a'];
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
        public void insert(String word){
            Node node=root;
            for(int i=word.length()-1;i>=0;i--){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                }
                node=node.get(ch);
            }
            node.setEnd();
        }
        public boolean containsPrefix(String word){
            Node node=root;
            for(int i=word.length()-1;i>=0;i--){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    return false;
                }
                node=node.get(ch);
            }
            return true;
        }
        
    }
    public int minimumLengthEncoding(String[] words) {
        Trie trie=new Trie();
        String ans="";
        for(String word:words){
            if(!trie.containsPrefix(word)){
              trie.insert(word);
              ans+=word;
              ans+="#";
            }
        }
        return ans.length();
    }
}