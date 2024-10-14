class Solution {
    public int leastInterval(char[] tasks, int n) {
        int freq[]=new int[26];
        for(char ch:tasks){
            freq[ch-'A']++;
        }
        Arrays.sort(freq);
        int maxFreq=freq[25];
        int indlespot=(maxFreq-1)*n;
        int cnt=0;
        for(int i=24;i>=0;i--){
            indlespot-=Math.min(freq[i],maxFreq-1);
        }
        return indlespot<0?tasks.length:tasks.length+indlespot;
        
    }
}