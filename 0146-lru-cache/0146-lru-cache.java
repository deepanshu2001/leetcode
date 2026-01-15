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
    int capacity;
    int size;
    Map<Integer,DLL> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.head=new DLL(0,0);
        this.tail=new DLL(0,0);
        head.next=tail;
        tail.prev=head;
        this.capacity=capacity;
        this.size=0;
    }
    public void add(DLL node){
        DLL headNext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headNext;
        headNext.prev=node;
        map.put(node.key,node);
        size++;
    }
    public void remove(DLL node){
        map.remove(node.key);
        DLL prevNode=node.prev;
        DLL nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
        node.next=null;
        node.prev=null;
        size--;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLL node=map.get(key);
        remove(node);
        add(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        DLL node=new DLL(key,value);
        if(map.containsKey(key)){
            remove(node);
        }
        if(size==capacity){
            remove(tail.prev);
        }
        add(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */