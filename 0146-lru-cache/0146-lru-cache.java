class LRUCache {
    class DLL{
        int key;
        int val;
        DLL prev;
        DLL next;
        DLL(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    Map<Integer,DLL> map;
    DLL head;
    DLL tail;
    int capacity;
    int size;
    public LRUCache(int capacity) {
        map=new HashMap<>();
        size=0;
        this.capacity=capacity;
        head=new DLL(0,0);
        tail=new DLL(0,0);
        head.next=tail;
        tail.prev=head;
    }
    public void remove(DLL node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        size--;
    }
    public void insert(DLL node){
       map.put(node.key,node);
       DLL head_next=head.next;
       node.prev=head;
       head.next=node;
       node.next=head_next;
       head_next.prev=node;
       size++;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLL node=map.get(key);
        remove(node);
        insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(size==capacity){
            remove(tail.prev);
        }
        
        insert(new DLL(key,value));

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */