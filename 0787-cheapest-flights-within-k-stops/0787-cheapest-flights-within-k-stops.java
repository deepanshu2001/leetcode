class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    class Triple{
        int first;
        int second;
        int third;
        public Triple(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i=0;i<flights.length;i++){
            int u=flights[i][0];
            int v=flights[i][1];
            int wt=flights[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int dist[]=new int[n];
        for(int i=0;i<n;i++){
            dist[i]=(int)1e9;
        }
        dist[src]=0;
        PriorityQueue<Triple> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Triple(0,0,src));
       
        while(pq.size()!=0){
            Triple tr=pq.remove();
            int step=tr.first;
            int price=tr.second;
            int node=tr.third;
            if(step>k){
                continue;
            }
            
            for(int i=0;i<adj.get(node).size();i++){
                int v=adj.get(node).get(i).first;
                int wt=adj.get(node).get(i).second;
                if(price+wt<dist[v]){
                    dist[v]=price+wt;
                    pq.add(new Triple(step+1,price+wt,v));
                }
            }
        }
     if(dist[dst]==1e9){
        return -1;
     }
     return dist[dst];
    }
}