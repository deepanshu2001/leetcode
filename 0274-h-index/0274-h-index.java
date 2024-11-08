class Solution {
    public int hIndex(int[] citations) {
        if(citations.length==1 && citations[0]==0){
            return 0;
        }
        if(citations.length==1){
            return 1;
        }
        int s=0;
        int e=citations.length;
        while(s<e){
            int h=s+(e-s)/2;
            int cnt=0;
            for(int i=0;i<citations.length;i++){
                if(citations[i]>=h){
                    cnt++;
                }
            }
            if(cnt>=h){
                s=h;
            }
            else{
                e=h-1;
            }
        }
        return s;
    }
}