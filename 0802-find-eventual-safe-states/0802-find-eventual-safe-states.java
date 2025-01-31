class Solution {
    public boolean dfs(Integer node,int []vis,int pathvis[],int check[],List<List<Integer>> adj){
        vis[node]=1;
        pathvis[node]=1;
        for(int it:adj.get(node)){
            if(vis[it]==0){
                if(dfs(it, vis, pathvis, check, adj)){
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
        List<List<Integer>> adj=new ArrayList<>();

        for(int []row:graph){
            List<Integer> list=new ArrayList<>();
            for(int col:row){
                list.add(col);
            }
            adj.add(list);
        }
        int vis[]=new int[graph.length];
        int pathvis[]=new int[graph.length];
        int check[]=new int[graph.length];
        List<Integer> safenodes=new ArrayList<Integer>();
        for(int i=0;i<adj.size();i++){
            if(vis[i]==0){
                dfs(i,vis,pathvis,check,adj);
            }
        }
        for(int i=0;i<graph.length;i++){
            if(check[i]==1){
               safenodes.add(i);
            }
        }
        return safenodes;
    }
}