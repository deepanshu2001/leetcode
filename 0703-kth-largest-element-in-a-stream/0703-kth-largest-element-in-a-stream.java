class KthLargest {
    int k;
    List<Integer> list;
    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.list=new ArrayList<>();
        for(int num:nums){
            list.add(num);
        }
    }
    
    public int add(int val) {
        list.add(val);
        Collections.sort(list);
        int cnt=k;
        for(int i=list.size()-1;i>=0;i--){
            if(cnt==1){
                return list.get(i);
            }
            cnt--;
        }
        return -1;
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */