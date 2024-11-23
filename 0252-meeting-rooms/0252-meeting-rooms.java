class Solution {
    public boolean canAttendMeetings(int[][] intervals) {
        PriorityQueue<int []> pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<intervals.length;i++){
            pq.add(new int[]{intervals[i][0],intervals[i][1]});
        }
        if(pq.size()==0){
            return true;
        }
        int arr[]=pq.poll();
        int start=arr[0];
        int end=arr[1];
        while(!pq.isEmpty()){
            int a[]=pq.remove();
            if(a[0]>=end){
                end=a[1];
            }
            else{
                return false;
            }
        }
        return true;
    }
}