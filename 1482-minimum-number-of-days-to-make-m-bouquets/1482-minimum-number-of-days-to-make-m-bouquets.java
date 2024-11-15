class Solution {
    
    public int minDays(int[] bloomDay, int m, int k) {
        int n=bloomDay.length;
        if(n<(long)m*k){
            return -1;
        }
        long ans=0;
        long max=Long.MIN_VALUE;
        long min=Long.MAX_VALUE;
        for(int i=0;i<bloomDay.length;i++){
            max=Math.max(max,bloomDay[i]);
            min=Math.min(min,bloomDay[i]);
        }
        long s=min;
        long e=max;
        while(s<=e){
            long mid=s+(e-s)/2;
            int cnt=0;
            int no_of_b=0;
            int b=0;
            
            for(int i=0;i<bloomDay.length;i++){
                if(bloomDay[i]<=mid){
                    cnt++;
                }
                else{
                   cnt=0;
                }
                if(cnt==k){
                    no_of_b++;
                    cnt=0;
                }

            }
            
            if(no_of_b<m){
               s=mid+1;
            }
            else{
                ans=mid;
                e=mid-1;
            }

        }
        return (int)ans;
    }
}