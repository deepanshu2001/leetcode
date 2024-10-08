class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int e=0;
        for(int i=0;i<piles.length;i++){
            e=Math.max(e,piles[i]);
        }
        while(s<e){
            int mid=s+(e-s)/2;
            int hrs=0;
            for(int i=0;i<piles.length;i++){
                hrs+=Math.ceil(piles[i]*1.0/mid);
            }
            if(hrs>h){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;
    }
}