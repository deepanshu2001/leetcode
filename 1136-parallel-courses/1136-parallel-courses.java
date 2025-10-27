class Solution {
    public int minimumSemesters(int n, int[][] relations) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<relations.length;i++){
           int u=relations[i][0];
           int v=relations[i][1];
           adj.get(u).add(v);
        }
        int ind[]=new int[n+1];
        for(int i=1;i<=n;i++){
            for(Integer it:adj.get(i)){
                ind[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
        List<Integer> ans=new ArrayList<>();
        for(int i=1;i<=n;i++){
            if(ind[i]==0){
                queue.add(i);
            }
        }
        while(!queue.isEmpty()){
            Integer node=queue.remove();
            ans.add(node);
            for(int it:adj.get(node)){
                ind[it]--;
                if(ind[it]==0){
                    queue.add(it);
                }
            }
        }
        if(ans.size()!=n){
            return -1;
        }
        return n-1;
    }
}