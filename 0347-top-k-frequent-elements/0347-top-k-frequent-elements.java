class Solution {
    public class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int value=m.getValue();
            pq.add(new Pair(value,key));
            while(pq.size()>k){
                pq.remove();
            }
        }
        int ans[]=new int[k];
        int ind=0;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int n=p.second;
            ans[ind++]=n;
        }
        return ans;
    }
}