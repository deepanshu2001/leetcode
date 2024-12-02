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
        List<Integer> list=new ArrayList<>(map.values());
        Collections.sort(list,Collections.reverseOrder());
        for(int i=0;i<K;i++){
            total+=list.get(i);
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