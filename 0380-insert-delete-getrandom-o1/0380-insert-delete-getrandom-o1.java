class RandomizedSet {
    Map<Integer,Integer> map;
    Random rand;
    public RandomizedSet() {
        map=new HashMap<>();
        rand=new Random();
    }
    
    public boolean insert(int val) {
        if(!map.containsKey(val)){
          map.put(val,1);
          return true;
        }
        map.put(val,map.get(val)+1);
        return false;
    }
    
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        map.put(val,map.get(val)-1);
        if(map.get(val)==0){
            map.remove(val);
        }
        return true;
    }
    
    public int getRandom() {
        List<Integer> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int val=m.getValue();
            while(val>0){
                list.add(m.getKey());
                val--;
            }
        }
        int ind=rand.nextInt(0,list.size());
        return list.get(ind);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */