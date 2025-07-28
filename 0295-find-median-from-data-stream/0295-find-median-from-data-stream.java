class MedianFinder {
    PriorityQueue<Integer> pq1;
    PriorityQueue<Integer> pq2;
    public MedianFinder() {
        pq1=new PriorityQueue<>(Collections.reverseOrder());
        pq2=new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(pq1.size()==0||num<=pq1.peek()){
            pq1.add(num);
        }
        else{
            pq2.add(num);
        }
        if(pq1.size()<pq2.size()){
            pq1.add(pq2.remove());
        }
        else if(pq1.size()>pq2.size()+1){
            pq2.add(pq1.remove());
        }
    }
    
    public double findMedian() {
        if(pq1.size()==pq2.size()){
            return pq1.peek()/2.0+pq2.peek()/2.0;
        }
        return pq1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */