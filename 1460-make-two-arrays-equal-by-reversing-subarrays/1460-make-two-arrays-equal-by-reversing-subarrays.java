class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        for(int i=0;i<target.length;i++){
            if(map.containsKey(target[i])==false){
                return false;
            }
            if(map.containsKey(target[i])){
                map.put(target[i],map.get(target[i])-1);
                if(map.get(target[i])==0){
                    map.remove(target[i]);
                }
            }
           
        }
        if(map.isEmpty()){
            return true;
        }
        return false;
    }

}