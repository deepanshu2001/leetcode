class Node{
    Node links[]=new Node[26];
    int cp=0;
    int ew=0;
    public boolean containsKey(char ch){
        return links[ch-'a']!=null;
    }
    public void put(char ch,Node node){
        links[ch-'a']=node;
    }
    public Node get(char ch){
        return links[ch-'a'];
    }
    public void increasePrefix(){
        cp++;
    }
    public void increaseEnd(){
        ew++;
    }
    public int getendWith(){
        return ew;
    }
    public void reducePrefix(){
        cp--;
    }
    public void reduceEnd(){
        ew--;
    }
}
class Trie {
    private Node root;
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
            node.increasePrefix();
        }
        node.increaseEnd();

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
       
        return node.getendWith();
    }
    
    public int countWordsStartingWith(String prefix) {
        Node node=root;
        for(int i=0;i<prefix.length();i++){
            char ch=prefix.charAt(i);
            if(node.containsKey(ch)){
                node=node.get(ch);
            }
            else{
                return 0;
            }
        }
        return node.cp;
    }
    
    public void erase(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++){
            char ch=word.charAt(i);
            if(node.containsKey(ch)){
                node=node.get(ch);
                node.reducePrefix();
            }
            else{
                return;
            }
        }
        node.reduceEnd();

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