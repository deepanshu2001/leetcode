class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int start=0;
        int neg=0;
        int dist=0;
        for(int i=0;i<gas.length;i++){
            dist+=gas[i]-cost[i];
            if(dist<0){
                neg+=dist;
                dist=0;
                start=i+1;
            }
        }
        if(dist+neg<0){
            return -1;
        }
        return start;
    }
}