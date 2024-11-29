class Solution {
    class Pair{
        int first;
        String second;
        Pair(int first,String second){
            this.first=first;
            this.second=second;
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list=new ArrayList<>();
        Map<String,Integer> map=new HashMap<>();
        for(int i=0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.first-x.first);
        for(Map.Entry<String,Integer> m:map.entrySet()){
            pq.add(new Pair(m.getValue(),m.getKey()));
        }
        while(!pq.isEmpty()){
            if(k<=0){
                break;
            }
            Pair p1=pq.remove();
            if(!pq.isEmpty() && pq.peek().first==p1.first){
              String s1=p1.second;
              String s2=pq.remove().second;
              if(s1.compareTo(s2)<=0){
                 list.add(s1);
                 list.add(s2);
              }
              else{
                list.add(s2);
                list.add(s1);
                k--;
                k--;
              }
            }
            else{
                list.add(p1.second);
                k--;
            }
            
        }
        
        return list;

    }
}