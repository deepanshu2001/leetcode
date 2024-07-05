class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long s=1;
        // Long m=Long.MAX_VALUE;
        // for(int i=0;i<time.length;i++){
        //     m=Math.min(m,time[i]);
        // }
        long e=Long.MAX_VALUE;
        while(s<=e){
            long mid=s+(e-s)/2;
            long t=0;
            for(int i=0;i<time.length;i++){
                
                t+=mid/time[i];
            }
            
            if(t<totalTrips){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
}