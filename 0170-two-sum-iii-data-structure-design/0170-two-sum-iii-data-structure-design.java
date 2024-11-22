class TwoSum {
    List<Integer> list;
  
    public TwoSum() {
        list=new ArrayList<>();
    }
    
    public void add(int number) {
        list.add(number);
    }
    
    public boolean find(int value) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<list.size();i++){
            if(map.containsKey(list.get(i))){
                return true;
            }
            map.put(value-list.get(i),i);
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