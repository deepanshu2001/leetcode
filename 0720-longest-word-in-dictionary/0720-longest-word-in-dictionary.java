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
        public boolean containsWord(String word){
            Node node=root;
            for(int i=word.length()-1;i>=0;i--){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    return false;
                }
                node=node.get(ch);
            }
            return node.isEnd();
        }
        
    }
    public String longestWord(String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        String ans="";
        for(String word:words){
            String s="";
            boolean flag=true;
            for(int i=0;i<word.length();i++){
                s+=word.charAt(i);
                if(!trie.containsWord(s)){
                    flag=false;
                    break;
                }
            }
            if(flag){
                if(ans.length()<word.length()||word.compareTo(ans)<0){
                    ans=word;
                }
            }
        }
        return ans;
    }
}