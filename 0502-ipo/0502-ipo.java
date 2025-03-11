class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        List<Pair> list=new ArrayList<>();
        for(int i=0;i<profits.length;i++){
            list.add(new Pair(capital[i],profits[i]));
        }
        Collections.sort(list,(l1,l2)->l1.first-l2.first);
        int ptr=0;
        for(int i=0;i<k;i++){
            while(ptr<profits.length && list.get(ptr).first<=w){
                pq.add(list.get(ptr).second);
                ptr++;
            }
            if(pq.isEmpty()){
                break;
            }
            w+=pq.remove();
        }
        return w;
    }
}