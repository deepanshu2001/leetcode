class Solution {
    class Node{
        Node []links=new Node[26];
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
        public boolean isEnd(){
            return flag==true;
        }
        public void setEnd(){
            flag=true;
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
        }
        public boolean startsWith(String prefix){
            Node node=root;
            for(int i=0;i<prefix.length();i++){
                char ch=prefix.charAt(i);
                if(!node.containsKey(ch)){
                    return false;
                }
                node=node.get(ch);
            }
            return true;
        }
    }
    public int countPrefixSuffixPairs(String[] words) {
        int cnt=0;
        for(int i=0;i<words.length;i++){
            Trie prefixTrie=new Trie();
            Trie suffixTrie=new Trie();
            prefixTrie.insert(words[i]);
            String reversestr=new StringBuilder(words[i]).reverse().toString();
            suffixTrie.insert(reversestr);
            for(int j=0;j<i;j++){
                if(words[j].length()>words[i].length()){
                    continue;
                }
                String prefixword=words[j];
                String suffixword=new StringBuilder(words[j]).reverse().toString();
                if(prefixTrie.startsWith(prefixword) && suffixTrie.startsWith(suffixword)){
                    cnt++;
                }
            }
        }
        return cnt;
    }
}