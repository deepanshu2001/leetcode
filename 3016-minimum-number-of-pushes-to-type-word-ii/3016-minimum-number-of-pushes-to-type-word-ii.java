class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int minimumPushes(String word) {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<word.length();i++){
           char ch=word.charAt(i);
           map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(Map.Entry<Character,Integer> m:map.entrySet()){
           pq.add(m.getValue());
        }
        int cnt=1;
        int n=0;
        int ans=0;
        while(!pq.isEmpty()){
            int num=pq.remove();
            n++;
            if(n>8){
                n=1;
                cnt++;
            }
            ans+=num*cnt;
        }
        return ans;
    }
}