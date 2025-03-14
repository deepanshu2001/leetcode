class Solution {
    public int maximumCandies(int[] candies, long k) {
        long long_sum=0;
        long max=Long.MIN_VALUE;
        for(int candy:candies){
            max=Math.max(max,(long)candy);
            long_sum+=candy;
        }
        if(long_sum<k){
            return 0;
        }
        long s=1;
        long e=max;
        while(s<=e){
            long mid=s+(e-s)/2;
            long cnt=0;
            for(int i=0;i<candies.length;i++){
               cnt+=candies[i]/mid;
            }
            if(cnt<k){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return (int)e;
    
    }
}