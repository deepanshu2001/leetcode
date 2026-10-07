class Solution {
    public void bfs(int i,int vis[],List<List<Integer>> adj){
        vis[i]=1;
        Queue<Integer> queue=new LinkedList<>();
        queue.add(i);
        while(!queue.isEmpty()){
            Integer node=queue.remove();
            for(Integer nei:adj.get(node)){
                if(vis[nei]==0){
                    queue.add(nei);
                    vis[nei]=1;
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj=new ArrayList<>();
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
            if(vis[i]==0){
              bfs(i,vis,adj);
              ans++;
            }
        }
        return ans;

    }
}