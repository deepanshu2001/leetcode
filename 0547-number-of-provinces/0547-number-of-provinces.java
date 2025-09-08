class Solution {
    class DisjointSet{
        List<Integer> parent=new ArrayList<>();
        List<Integer> rank=new ArrayList<>();
        List<Integer> size=new ArrayList<>();
        DisjointSet(int n){
           for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
           }
        }
        public int find_up(int node){
    if(node == parent.get(node)){
        return node;
    }
    int u_parent = find_up(parent.get(node));
    parent.set(node, u_parent);
    return u_parent;
}

        public void unionByRank(int u,int v){
            int up_u=find_up(u);
            int up_v=find_up(v);
            if(up_u==up_v){
                return;
            }
            if(rank.get(up_u)<rank.get(up_v)){
                parent.set(up_u,up_v);
            }
            else if(rank.get(up_v)<rank.get(up_u)){
                parent.set(up_v,up_u);
            }
            else{
                parent.set(up_v,up_u);
                rank.set(up_u,rank.get(up_u)+1);
            }
        }
        public void unionBySize(int u, int v){
    int up_u = find_up(u);
    int up_v = find_up(v);
    if(up_u == up_v){
        return;
    }
    if(size.get(up_u) < size.get(up_v)){
        parent.set(up_u, up_v);
        size.set(up_v, size.get(up_v) + size.get(up_u));
    } else {
        parent.set(up_v, up_u);
        size.set(up_u, size.get(up_u) + size.get(up_v));
    }
}
    }
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        DisjointSet ds=new DisjointSet(n);
        for(int i=0;i<isConnected.length;i++){
            for(int j=0;j<isConnected[i].length;j++){
                if(i!=j && isConnected[i][j]==1){
                    ds.unionBySize(i,j);
                }
            }
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(i==ds.find_up(i)){
                ans++;
            }
        }
        return ans;
    }
}