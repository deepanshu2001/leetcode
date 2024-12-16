class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    public int minMeetingRooms(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
         PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(x.second, y.second));
         pq.add(new Pair(intervals[0][0],intervals[0][1]));
         for(int i=1;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(start>=pq.peek().second){
                pq.poll();
            }
            pq.add(new Pair(intervals[i][0],intervals[i][1]));
         }
         return pq.size();
    }
}