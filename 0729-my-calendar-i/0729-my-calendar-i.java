class MyCalendar {
    TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map=new TreeMap<>();
    }
    
    public boolean book(int startTime, int endTime) {
        Integer prev=map.floorKey(startTime);
        Integer next=map.ceilingKey(startTime);
        if((prev==null || map.get(prev)<=startTime) && (next==null || endTime<=next)){
            map.put(startTime,endTime);
            return true;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */