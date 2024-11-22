class TwoSum {
    Map<Integer,Integer> map;
    public TwoSum() {
        map=new HashMap<>();
    }
    
    public void add(int number) {
        map.put(number,map.getOrDefault(number,0)+1);
    }
    
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> m:map.entrySet()){
            int comp=value-m.getKey();
            if(map.containsKey(comp)){
                return true;
            }           
        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */