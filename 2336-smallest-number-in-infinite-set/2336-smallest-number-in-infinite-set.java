class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        pq=new PriorityQueue<>();
        for(int i=1;i<1001;i++){
            pq.add(i);
        }
    }
    
    public int popSmallest() {
        return pq.remove();
    }
    
    public void addBack(int num) {
        if(pq.contains(num)==false){
            pq.add(num);
        }
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */