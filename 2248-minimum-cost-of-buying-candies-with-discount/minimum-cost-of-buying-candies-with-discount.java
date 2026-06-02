class Solution {
    public int minimumCost(int[] cost) {
        int dist=0;
        Arrays.sort(cost);
        int i=cost.length-1;
        while(i>=0){
            dist+=cost[i];
            i--;
            if(i>=0){
                dist+=cost[i];
                i--;
            }
            i--;
        }
        return dist;
    }
}