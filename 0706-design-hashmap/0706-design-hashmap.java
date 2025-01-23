class MyHashMap {
    class Entry{
        int key;
        int val;
        public Entry(int key,int val){
            this.key=key;
            this.val=val;
        }
    }
    int size=769;
    LinkedList<Entry> data[];
    public MyHashMap() {
        data=new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int bucket=key%size;
        if(data[bucket]==null){
            data[bucket]=new LinkedList<Entry>();
            data[bucket].add(new Entry(key,value));
        }
        else{
            for(Entry entry:data[bucket]){
                if(entry.key==key){
                    entry.val=value;
                    return;
                }
            }
            data[bucket].add(new Entry(key,value));
        }
        
    }
    
    public int get(int key) {
        int bucket=key%size;
        if(data[bucket]==null){
            return -1;
        }
        else{
            for (Entry entry:data[bucket]){
            if(entry.key==key){
                return entry.val;
            }
        }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket=key%size;
        Entry toremove=null;
        if(data[bucket]==null){
            return;
        }
        for(Entry entry:data[bucket]){
                if(entry.key==key){
                    toremove=entry;
                }
        }
        
        if(toremove==null){
            return;
        }
        data[bucket].remove(toremove);
        
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */