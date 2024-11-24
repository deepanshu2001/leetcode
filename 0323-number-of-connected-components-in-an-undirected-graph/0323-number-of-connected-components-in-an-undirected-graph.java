class Solution {
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node,int vis[]){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(adj,it,vis);
            }
        }
    }
    public int countComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        int vis[]=new int[n];
        int cnt=0;
        for(int i=0;i<n;i++){
            if(vis[i]==0){
               dfs(adj,i,vis);
               cnt++;
            }
        }
        return cnt;
    }
}