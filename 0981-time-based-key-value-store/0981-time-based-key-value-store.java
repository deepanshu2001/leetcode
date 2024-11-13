class TimeMap {
    Map<String,TreeMap<Integer,String>> map;
    public TimeMap() {
        map=new HashMap<String,TreeMap<Integer,String>>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
            map.put(key,new TreeMap<Integer,String>());
        }
        map.get(key).put(timestamp,value);
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        Integer floorkey=map.get(key).floorKey(timestamp);
        if(floorkey!=null){
            return map.get(key).get(floorkey);
        }
        return "";
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */