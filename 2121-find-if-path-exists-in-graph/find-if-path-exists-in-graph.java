class Solution {
    public boolean dfs(int node, List<List<Integer>> adj, int vis[], int destination) {
        if (node == destination) {
            return true;
        }
        vis[node] = 1;
        for (Integer it : adj.get(node)) {
            if (vis[it] == 0) {
                if (dfs(it, adj, vis, destination)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int vis[] = new int[n];
        return dfs(source, adj, vis, destination);
    }
}