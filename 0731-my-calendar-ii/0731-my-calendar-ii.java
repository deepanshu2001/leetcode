class MyCalendarTwo {
    TreeMap<Integer,Integer> map;
    int maxOverlap;
    public MyCalendarTwo() {
        maxOverlap=2;
        map=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        map.put(startTime,map.getOrDefault(startTime,0)+1);
        map.put(endTime,map.getOrDefault(endTime,0)-1);
        int overlapps=0;
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            overlapps+=m.getValue();
            if(overlapps>maxOverlap){
                map.put(startTime,map.get(startTime)-1);
                map.put(endTime,map.get(endTime)+1);
                if(map.get(startTime)==0){
                    map.remove(startTime);
                }
                return false;
            }
        }
        return true;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */