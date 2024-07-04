class Solution {
    public int minEatingSpeed(int[] piles, int h) {
       int max=Integer.MIN_VALUE;
       for(int i=0;i<piles.length;i++){
        max=Math.max(max,piles[i]);
       }
        int s=1;
        int e=max;
        while(s<e){
            int mid=s+(e-s)/2;
            int time=0;
            for(int i=0;i<piles.length;i++){
                time+=(int)Math.ceil((piles[i]*1.0)/mid);
            }
            if(time>h){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;
    }
}