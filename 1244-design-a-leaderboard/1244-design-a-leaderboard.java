class Leaderboard {
    Map<Integer,Integer> map;
    public Leaderboard() {
        map=new HashMap<>();
    }
    
    public void addScore(int playerId, int score) {
        if(!map.containsKey(playerId)){
            map.put(playerId,0);
        }
        map.put(playerId,map.get(playerId)+score);
    }
    
    public int top(int K) {
        int total=0;
        PriorityQueue<Map.Entry<Integer,Integer>> pq=new PriorityQueue<>((a,b)->a.getValue()-b.getValue());
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            pq.add(m);
            if(pq.size()>K){
                pq.remove();
            }
            
        }
        Iterator value=pq.iterator();
        while (value.hasNext()) { 
            total += ((Map.Entry<Integer, Integer>)value.next()).getValue();   
        }
        
        return total;
    }
    
    public void reset(int playerId) {
        map.put(playerId,0);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */