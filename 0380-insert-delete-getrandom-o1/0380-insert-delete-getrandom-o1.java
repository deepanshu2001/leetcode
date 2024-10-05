

import static java.lang.Math.random;

class RandomizedSet {
    Random random = new Random();
    Map<Integer,Integer> map;
    List<Integer> list;
    public RandomizedSet() {
        map=new HashMap<>();
        list=new ArrayList<Integer>();
    }
    
    public boolean insert(int val) {
        if(map.containsKey(val)==true){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }
    
    public boolean remove(int val) {
        if(map.containsKey(val)==false){
            return false;
        }
        int ind=map.get(val);
        int last_val=list.get(list.size()-1);
        list.set(ind,last_val);
        map.put(last_val,ind);
        list.remove(list.size()-1);
        map.remove(val);
        return true;
    }
    
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */