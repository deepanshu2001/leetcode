

import static java.lang.Math.log;

class Solution {
    public long countCompleteDayPairs(int[] hours) {
        Map<Integer,Integer> map=new HashMap<>();
        long cnt=0;
        for(int t:hours){
            int rem=t%24;
            int key=(24-rem)%24;
            if(map.containsKey(key)){
               cnt+=map.get(key);
            }
            map.put(rem,map.getOrDefault(rem,0)+1);
            
        }
        return cnt;
    }
}