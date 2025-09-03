class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
           int u=edges[i][0];
           int v=edges[i][1];
           adj.get(u).add(v);
        }
        int ind[]=new int[V];
        for(int i=0;i<adj.size();i++){
            for(int adjnode:adj.get(i)){
                ind[adjnode]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<V;i++){
            if(ind[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            int node=queue.remove();
            ans.add(node);
            for(int adjnode:adj.get(node)){
                ind[adjnode]--;
                if(ind[adjnode]==0){
                    queue.add(adjnode);
                }
            }
        }
        return ans;
        
    }
}