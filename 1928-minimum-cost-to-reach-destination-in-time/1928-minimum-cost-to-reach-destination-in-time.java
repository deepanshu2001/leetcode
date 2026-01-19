class Solution {
    class Triple{
        int cost;
        int time;
        int node;
        Triple(int cost,int time,int node){
            this.cost=cost;
            this.time=time;
            this.node=node;
        }
    }
    class Pair{
        int node;
        int time;
        Pair(int node,int time){
            this.node=node;
            this.time=time;
        }
    }
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        List<List<Pair>> adj=new ArrayList<>();
        int n=passingFees.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int []arr:edges){
            int u=arr[0];
            int v=arr[1];
            int wt=arr[2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int dist[]=new int[n];
        Arrays.fill(dist,maxTime+1);
        dist[0]=0;
        PriorityQueue<Triple> pq=new PriorityQueue<>((x,y)->x.cost==y.cost?x.time-y.time:x.cost-y.cost);
        pq.add(new Triple(passingFees[0],0,0));
        while(!pq.isEmpty()){
            Triple t=pq.remove();
            if(t.node==n-1){
                return t.cost;
            }
            for(Pair it:adj.get(t.node)){
              int newTime=t.time+it.time;
              if(dist[it.node]>newTime){
                dist[it.node]=newTime;
                pq.add(new Triple(passingFees[it.node]+t.cost,newTime,it.node));
              }
            }
        }
        return -1;
    }
}