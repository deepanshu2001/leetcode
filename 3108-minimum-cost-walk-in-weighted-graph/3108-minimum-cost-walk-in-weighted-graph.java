class DSU {
    private int[] ranks;
    private int[] parents;
    private int[] weights;

    public DSU(int n) {
        ranks = new int[n];
        parents = new int[n];
        weights = new int[n];
        Arrays.fill(weights, 131071);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    public void join(int a, int b, int e) {
        int pa = findParents(a);
        int pb = findParents(b);
        if (pa == pb) {
            weights[pa] &= e;
            return;
        }
        if (ranks[pa] < ranks[pb]) {
            parents[pa] = pb;
            weights[pb] &= weights[pa] & e;
        } else if (ranks[pa] > ranks[pb]) {
            parents[pb] = pa;
            weights[pa] &= weights[pb] & e;
        } else {
            parents[pa] = pb;
            weights[pb] &= weights[pa] & e;
            ranks[pb]++;
        }
    }

    public int findParents(int a) {
        if (parents[a] != a) {
            parents[a] = findParents(parents[a]);
        }
        return parents[a];
    }

    public int getWeight(int a) {
        return weights[a];
    }
}

class Solution {
    public int[] minimumCost(int n, int[][] edges, int[][] query) {
        DSU graph = new DSU(n);
        for (int[] edge : edges) {
            graph.join(edge[0], edge[1], edge[2]);
        }
        int[] ans = new int[query.length];
        for (int i = 0; i < query.length; i++) {
            int pa = graph.findParents(query[i][0]);
            int pb = graph.findParents(query[i][1]);
            ans[i] = (pa == pb ? graph.getWeight(pa) : -1);
        }
        return ans;
    }
}
