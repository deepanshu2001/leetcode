class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int maxF=freq[freq.length-1];
        int idlespot=(maxF-1)*n;
        for(int i=24;i>=0;i--){
            idlespot-=Math.min(freq[i],maxF-1);
        }
        return idlespot<0?tasks.length:tasks.length+idlespot;
    }
}