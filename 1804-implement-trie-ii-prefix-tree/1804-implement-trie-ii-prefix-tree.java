class Node{
    Node []links=new Node[26];
    int ew=0;
    int cp=0;
    Node(){

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
    public void incrementEnd(){
        ew++;
    }
    public void decrementEnd(){
        ew--;
    }
    public void incrementPrefix(){
        cp++;
    }
    public void decrementPrefix(){
        cp--;
    }
    public int getEndsWith(){
        return ew;
    }
}

class Trie {
    Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                node.put(ch,new Node());
            }
            node=node.get(ch);
            node.incrementPrefix();
        }
        node.incrementEnd();
    }
    
    public int countWordsEqualTo(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.getEndsWith();
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(!node.containsKey(ch)){
                return 0;
            }
            node=node.get(ch);
        }
        return node.cp;
    }
    
    public void erase(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(!node.containsKey(ch)){
                return;
            }
            node=node.get(ch);
            node.decrementPrefix();
        }
        node.decrementEnd();
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */