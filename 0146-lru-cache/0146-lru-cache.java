

class LRUCache {
    class DLL{
    int key;
    int val;
    DLL next;
    DLL prev;

    DLL(int key,int val){
        this.key=key;
        this.val=val;
    }
   }

    DLL head;
    DLL tail;
    int cap;
    int capacity;
    Map<Integer,DLL> map;
    public LRUCache(int capacity) {
        head=new DLL(0,0);
        tail=new DLL(0,0);
        head.next=tail;
        tail.prev=head;
        cap=0;
        map=new HashMap<>();
        this.capacity=capacity;
    }
    public void remove(DLL node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
        cap--;
    }
    public void insert(DLL node){
        map.put(node.key,node);
        DLL head_next=head.next;
        head.next=node;
        node.prev=head;
        node.next=head_next;
        head_next.prev=node;
        cap++;
        
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
        if(capacity==cap){
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