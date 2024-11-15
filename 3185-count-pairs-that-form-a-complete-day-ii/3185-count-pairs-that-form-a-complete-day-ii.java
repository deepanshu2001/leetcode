class Solution {
    public long countCompleteDayPairs(int[] hours) {
        long total=0;
        int hash[]=new int[24];
        for(int i : hours){
            total += hash[i%24];
            int rem = (24 - i % 24) % 24;
            hash[rem]+=1;
        }
        return total;
    }
}