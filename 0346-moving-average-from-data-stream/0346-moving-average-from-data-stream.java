class MovingAverage {
    int size;
    int prefix_sum=0;
    ArrayDeque<Integer> dq=new ArrayDeque<>();
    public MovingAverage(int size) {
        this.size=size;
    }
    
    public double next(int val) {
        dq.add(val);
        int tail=dq.size()>size?dq.removeFirst():0;
        prefix_sum=prefix_sum-tail+val;
        return prefix_sum*1.0/dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */