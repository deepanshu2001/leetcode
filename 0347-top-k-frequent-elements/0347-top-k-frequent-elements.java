class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        if(map.isEmpty()){
            int ans[]={};
            return ans;
        }
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int val=m.getValue();
            pq.add(new Pair(val,key));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int ans[]=new int[pq.size()];
        int ind=0;
        while(pq.size()!=0){
           ans[ind++]=pq.remove().second;
        }
        return ans;
    }
}