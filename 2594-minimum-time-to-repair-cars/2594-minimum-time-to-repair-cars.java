class Solution {
    public long repairCars(int[] ranks, int cars) {
        int min_rank=Integer.MAX_VALUE;
        for(int rank:ranks){
            min_rank=Math.min(min_rank,rank);
        }
        int n=cars;
        long s=(long)min_rank;
        long e=(long)(min_rank*n*n);
        while(s<e){
            long mid=s+(e-s)/2;
            long total_time=0;
            for(int i=0;i<ranks.length;i++){
                long sq=mid/ranks[i];
                total_time+=(long)Math.sqrt(sq);
            }
            if(total_time>=cars){
                e=mid;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
}