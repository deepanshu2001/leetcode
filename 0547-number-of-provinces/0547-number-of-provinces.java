class Solution {
    public void bfs(ArrayList<ArrayList<Integer>> adj,int vis[],int node){
       vis[node]=1;
       for(Integer it:adj.get(node)){
        if(vis[it]!=1){
            vis[it]=1;
            bfs(adj,vis,it);
        }
       }
    }
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        int n=isConnected.length;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i!=j && isConnected[i][j]==1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        int vis[]=new int[n];
        int ans=0;
        for(int i=0;i<n;i++){
            if(vis[i]!=1){
                vis[i]=1;
                bfs(adj,vis,i);
                ans++;
            }
        }
        return ans;
    }
}