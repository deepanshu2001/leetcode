class KthLargest {
    int size;
    PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        pq=new PriorityQueue<>();
        size=k;
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
            if(pq.size()>size){
                pq.remove();
            }
        }
        
    }
    
    public int add(int val) {
        pq.add(val);
        while(pq.size()>size){
            pq.remove();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */