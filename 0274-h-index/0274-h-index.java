class Solution {
    public int hIndex(int[] citations) {
        int ans=0;
        for(int i=1;i<=citations.length;i++){
            int h=i;
            int cnt=0;
            for(int j=0;j<citations.length;j++){
                if(citations[j]>=h){
                    cnt++;
                }
            }
            if(cnt>=h){
                ans=i;
            }
        }
        return ans;
    }
}