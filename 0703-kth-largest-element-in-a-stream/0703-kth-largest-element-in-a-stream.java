class KthLargest {
    int k;
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int num:nums){
            pq.add(num);
        }
    }
    
    public int add(int val) {
        pq.add(val);
        List<Integer> list=new ArrayList<>();
        while(pq.size()>k){
            list.add(pq.remove());
        }
        int res=pq.peek();
        for(int num:list){
            pq.add(num);
        }
        return res;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */