class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void dfs(int node, List<Integer> list, List<List<Integer>> adj, int vis[]) {
        list.add(node);

        if (node == adj.size() - 1) {
            ans.add(new ArrayList<>(list));
            list.remove(list.size() - 1); // backtrack
            return;
        }

        vis[node] = 1;
        for (Integer adjnode : adj.get(node)) {
            if (vis[adjnode] == 0) {
                dfs(adjnode, list, adj, vis);
            }
        }
        vis[node] = 0;

        list.remove(list.size() - 1); // backtrack
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int n = graph.length;

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(i).add(graph[i][j]);
            }
        }

        int vis[] = new int[n];
        dfs(0, new ArrayList<>(), adj, vis);
        return ans;
    }
}
