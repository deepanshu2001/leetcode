class LRUCache {
    class DLL{
        int key;
        int value;
        DLL prev;
        DLL next;
        DLL(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    DLL head;
    DLL tail;
    int size=0;
    int cap=0;
    Map<Integer,DLL> map=new HashMap<>();
    public LRUCache(int capacity) {
        this.size=0;
        this.cap=capacity;
        head=new DLL(0,0);
        tail=new DLL(0,0);
        head.next=tail;
        tail.prev=head;
    }
    public void remove(DLL node){
        map.remove(node.key);
        DLL prevnode=node.prev;
        prevnode.next=node.next;
        node.next.prev=prevnode;
        node.next=null;
        node.prev=null;
    }
    public void add(DLL node){
        map.put(node.key,node);
        DLL headnext=head.next;
        head.next=node;
        node.prev=head;
        node.next=headnext;
        headnext.prev=node;
    }
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        DLL node=map.get(key);
        remove(node);
        add(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        else if(map.size()==cap){
            remove(tail.prev);
        }
        add(new DLL(key,value));
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */