class Solution {
    class Pair implements Comparable<Pair>{
        int cost,node;
        Pair(int node,int cost){
            this.node=node;
            this.cost=cost;
        }
        public int compareTo(Pair t){
            return this.cost - t.cost;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        int vis[]=new int[n];
        int dist[]=new int[n];
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        Arrays.fill(dist,Integer.MAX_VALUE);
        int sum=0;
        dist[0]=0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair pair=pq.remove();
            int cost=pair.cost;
            int node=pair.node;
            if(vis[node]==1){
                continue;
            }
            vis[node]=1;
            sum+=cost;
            int x1=points[node][0];
            int y1=points[node][1];
            for(int v=0;v<n;v++){
                if(vis[v]==0){
                    int diff=Math.abs(x1-points[v][0])+Math.abs(y1-points[v][1]);
                    if(diff<dist[v]){
                        dist[v]=diff;
                        pq.add(new Pair(v,diff));
                    }
                }
            }
        }
        return sum;
    }
}