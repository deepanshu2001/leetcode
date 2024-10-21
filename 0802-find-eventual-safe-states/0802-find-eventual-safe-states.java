class Solution {
    public boolean dfs(ArrayList<ArrayList<Integer>> adj,int vis[],int pathvis[],int node,int []check ){
        vis[node]=1;
        pathvis[node]=1;
        check[node]=0;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(adj,vis,pathvis,it,check)==true){
                    return true;
                }
            }
            else if(pathvis[it]==1){
                return true;
            }
        }
        pathvis[node]=0;
        check[node]=1;
        return false;
        
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans=new ArrayList<>();
        int n=graph.length;
        int m=graph[0].length;
        int vis[]=new int[n];
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<graph[i].length;j++){
                adj.get(i).add(graph[i][j]);
            }
        }
        int pathvis[]=new int[n];
        int check[]=new int[n];
        for(int i=0;i<n;i++){
            if(vis[i]==0){
                dfs(adj,vis,pathvis,i,check);
            }
        }
        for(int i=0;i<n;i++){
            if(check[i]==1){
               ans.add(i);
            }
        }
        return ans;

    }
}