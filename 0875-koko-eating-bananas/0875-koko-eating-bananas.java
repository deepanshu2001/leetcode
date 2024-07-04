class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int s=1;
        int max=Integer.MIN_VALUE;
        for(int i:piles){
           if(i>max){
               max=i;
           }
        }
        int e=max;
        
        while(s<e){
            int totalt=0;
            int mid=s+(e-s)/2;
            for(int j:piles){
                if(mid!=0){
                   totalt=totalt+(int)Math.ceil(j*1.0/mid);
                }
            }
            if(totalt>h){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s;
    }
}