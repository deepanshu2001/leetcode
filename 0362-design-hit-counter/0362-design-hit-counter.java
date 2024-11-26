class HitCounter {
    Map<Integer,Integer> map;
    public HitCounter() {
        map=new HashMap<>();
    }
    
    public void hit(int timestamp) {
        map.put(timestamp,map.getOrDefault(timestamp,0)+1);
    }
    
    public int getHits(int timestamp) {
        int initial_time=timestamp-300+1;
        int cnt=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            if(m.getKey()>=initial_time && m.getKey()<=timestamp){
                cnt+=m.getValue();
            }
        }
        return cnt;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */