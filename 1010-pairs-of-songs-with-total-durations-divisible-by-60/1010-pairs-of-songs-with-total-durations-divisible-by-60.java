class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
        for(int t:time){
            int rem=t%60;
            int key=(60-rem)%60;
            if(map.containsKey(key)){
               cnt+=map.get(key);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
            
        }
        return cnt;
    }
}