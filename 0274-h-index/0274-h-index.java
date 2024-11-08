class Solution {
    public int hIndex(int[] citations) {
        int ans=0;
        int h=0;
        Arrays.sort(citations);
        int cnt=0;
        int i=0;
        while(i<citations.length){
            if(citations[i]>=h){
                cnt=citations.length-i;
            }
            if(cnt>=h){
                ans=h;
                h++;
                cnt=0;
                i=-1;
            }
            i++;
        }
        return ans;
    }
}