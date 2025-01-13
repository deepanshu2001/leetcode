class Solution {
    class Pair{
        char first;
        int second;
        public Pair(char first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public String reorganizeString(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.second-x.second);
        for(Map.Entry<Character,Integer> m:map.entrySet()){
           pq.add(new Pair(m.getKey(),m.getValue()));
        }
        StringBuilder sb=new StringBuilder();
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            char ch=p.first;
            int cnt=p.second;
            if(sb.length()==0||sb.charAt(sb.length()-1)!=ch){
                sb.append(ch);
                cnt--;
                if(cnt>0){
                    pq.add(new Pair(ch,cnt));
                }
            }
            else{
                if(pq.isEmpty()){
                    return "";
                }
                else{
                    Pair q=pq.remove();
                    char second_char=q.first;
                    int new_cnt=q.second;
                    sb.append(second_char);
                    new_cnt--;
                    if(new_cnt>0){
                        pq.add(new Pair(second_char,new_cnt));
                    }
                    pq.add(new Pair(ch,cnt));
                }
            }
        }
        return sb.toString();
    }
}