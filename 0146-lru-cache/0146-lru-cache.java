class LRUCache {
    class Node{
        Node next;
        Node prev;
        int key,value;
        public Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    int capacity=0;
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer,Node> map=new HashMap<>(); 
    public LRUCache(int capacity) {
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;

    }
    public void remove(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insert(Node node){
       map.put(node.key,node);
       Node temp=head.next;
       head.next=node;
       node.prev=head;
       node.next=temp;
       temp.prev=node;
    }
    public int get(int key) {
        if(map.containsKey(key)==false){
            return -1;
        }
        Node node=map.get(key);
        remove(node);
        insert(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node=new Node(key,value);
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size()==capacity){
           remove(tail.prev);
        }
        insert(node);
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */