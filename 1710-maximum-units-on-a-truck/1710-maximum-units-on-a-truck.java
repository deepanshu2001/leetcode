class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes,(a,b)->b[1]-a[1]);
        int ans=0;
        for(int i=0;i<boxTypes.length;i++){
            int t=boxTypes[i][0];
            int units=boxTypes[i][1];
            int actual=Math.min(truckSize,t);
            ans+=actual*units;
            truckSize=truckSize-actual;
        }
        return ans;
    }
}