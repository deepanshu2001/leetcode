class Solution {
    public long minimumHealth(int[] damage, int armor) {
        int totaldamage=0;
        long maxDamage=0;
        for(int d:damage){
            totaldamage+=d;
            maxDamage=Math.max(maxDamage,d);
        }
        return totaldamage-Math.min(armor,maxDamage)+1;
    }
}