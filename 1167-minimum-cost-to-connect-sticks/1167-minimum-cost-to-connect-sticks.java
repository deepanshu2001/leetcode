class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int num:sticks){
            pq.add(num);
        }
        int cost=0;
        while(pq.size()>1){
            int x=pq.remove();
            int y=pq.remove();
            cost+=x+y;
            pq.add(x+y);
        }
        return cost;
    }
}