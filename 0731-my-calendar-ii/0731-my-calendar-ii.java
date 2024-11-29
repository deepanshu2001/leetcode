class MyCalendarTwo {
    List<int[]> bookings;
    List<int[]> overlapped;
    public boolean isOverlapped(int start1,int end1,int start2,int end2){
        return Math.max(start1,start2)<Math.min(end1,end2);
    }
    public int[] findOverlapped(int start1,int end1,int start2,int end2){
        int new_start=Math.max(start1,start2);
        int new_end=Math.min(end1,end2);
        return new int[]{new_start,new_end};
    }
    public MyCalendarTwo() {
        bookings=new ArrayList<>();
        overlapped=new ArrayList<>();
    }
    
    public boolean book(int startTime, int endTime) {
      for(int booking[]:overlapped){
        if(isOverlapped(booking[0],booking[1], startTime, endTime)){
            return false;
        }
      }
      for(int []booking:bookings){
        if(isOverlapped(booking[0],booking[1],startTime,endTime)){
            overlapped.add(findOverlapped(booking[0],booking[1],startTime,endTime));
        }
      }
      bookings.add(new int[]{startTime,endTime});
      return true;
         
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(startTime,endTime);
 */