class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
         PriorityQueue<Pair> pq = new PriorityQueue<>((p, q)->(p.first==q.first)?q.second-p.second:q.first-p.first);
        
        for(int i=0;i<arr.length;i++){
           pq.add(new Pair(Math.abs(x-arr[i]),arr[i]));
           if(pq.size()>k){
             pq.remove();
           }
        }
        List<Integer> ans=new ArrayList<>();
        while(pq.size()!=0){
           Pair pair=pq.remove();
           ans.add(pair.second);
        }
        Collections.sort(ans);
        return ans;
    }
}