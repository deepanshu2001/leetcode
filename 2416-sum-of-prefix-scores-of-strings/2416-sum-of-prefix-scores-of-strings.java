class Solution {
    class Node{
        Node []links=new Node[26];
        int sc=0;
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
                node.sc+=1;
            }
            node.setEnd();
        }
        public int calculateScore(String word){
            int cnt=0;
            Node node=root;
            for(int i=0;i<word.length();i++){
                char ch=word.charAt(i);
                node=node.get(ch);
                cnt+=node.sc;
            }
            return cnt;
        }
    }
    public int[] sumPrefixScores(String[] words) {
        Trie trie=new Trie();
        for(String word:words){
            trie.insert(word);
        }
        int ans[]=new int[words.length];
        for(int i=0;i<words.length;i++){
            ans[i]=trie.calculateScore(words[i]);
        }
        return ans;
    }
}