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
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(!node.containsKey(ch)){
                    node.put(ch,new Node());
                }
                node=node.get(ch);
            }
            node.setEnd();
        }
        public String searchShortest(String word){
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                if(node.links[ch-'a']==null){
                    return word;
                }
                node=node.get(ch);
                if(node.isEnd()){
                    return word.substring(0,i+1);
                }
            }
            return word;
        }
    }
    public String replaceWords(List<String> dictionary, String sentence) {
        String words[]=sentence.split(" ");
        Trie trie=new Trie();
        for(String word:dictionary){
            trie.insert(word);
        }
        for(int i=0;i<words.length;i++){
            words[i]=trie.searchShortest(words[i]);
        }
        return String.join(" ",words);
    }
}