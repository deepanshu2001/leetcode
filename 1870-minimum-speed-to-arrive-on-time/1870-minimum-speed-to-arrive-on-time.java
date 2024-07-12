class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int s=1;
        int e=100000;
        int result=-1;
        while(s<=e){
            int mid=s+(e-s)/2;
            double time=0;
            for(int i=0;i<dist.length-1;i++){
                time+=Math.ceil(dist[i]*1.0/mid);
            }
            time+=dist[dist.length-1]*1.0/mid;
            if(time<=hour){
                result=mid;
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return result;
    }
}