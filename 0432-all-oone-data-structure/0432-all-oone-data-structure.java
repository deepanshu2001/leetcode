class AllOne {
    Map<String,Integer> map;
    public AllOne() {
        map=new HashMap<>();
    }
    
    public void inc(String key) {
        map.put(key,map.getOrDefault(key,0)+1);
    }
    
    public void dec(String key) {
        if(map.containsKey(key)==false){
            return;
        }
        map.put(key,map.get(key)-1);
        if(map.get(key)==0){
            map.remove(key);
        }
    }
    
    public String getMaxKey() {
        int max=Integer.MIN_VALUE;
        String s="";
        for(Map.Entry<String,Integer> m:map.entrySet()){
            if(m.getValue()>max){
                max=m.getValue();
                s=new String(m.getKey());
            }
        }
        if(max==Integer.MIN_VALUE){
            return "";
        }
        return s;
    }
    
    public String getMinKey() {
        int min=Integer.MAX_VALUE;
        String s="";
        for(Map.Entry<String,Integer> m:map.entrySet()){
            if(m.getValue()<min){
                min=m.getValue();
                s=new String(m.getKey());
            }
        }
        if(min==Integer.MAX_VALUE){
            return "";
        }
        return s;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */