class Solution {
    class Pair{
        int first;
        int second;
        int third;
        public Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> Integer.compare(y.first, x.first));
        for(int i=0;i<points.length;i++){
            int dist=points[i][0]*points[i][0]+points[i][1]*points[i][1];
            pq.add(new Pair(dist,points[i][0],points[i][1]));
            while(pq.size()>k){
                pq.remove();
            }
        }
        int ans[][]=new int[k][2];
        int ind=0;
        while(!pq.isEmpty()){
           Pair pair=pq.remove();
           ans[ind][0]=pair.second;
           ans[ind][1]=pair.third;
           ind++;
        }
        return ans;
    }
}