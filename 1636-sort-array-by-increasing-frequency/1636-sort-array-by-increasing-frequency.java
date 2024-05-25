class Pair{
    int first;
    int second;
    public Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}
class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])==false){
                map.put(nums[i],1);
            }
            else{
                map.put(nums[i],map.get(nums[i])+1);
            }
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->(x.first==y.first)?y.second-x.first:x.first-y.first);
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int key=m.getKey();
            int value=m.getValue();
            pq.add(new Pair(value,key));
        }
        int ind=0;
        int ans[]=new int[nums.length];
        while(pq.size()!=0){
            Pair pair=pq.remove();
            int freq=pair.first;
            int num=pair.second;
            while(freq>0){
              ans[ind++]=num;
              freq--;
            }
        }
        return ans;
    }
}