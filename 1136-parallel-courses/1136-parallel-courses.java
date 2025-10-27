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
        int semester=0;
        int course=0;
        while(!queue.isEmpty()){
           int size=queue.size();
           semester++;
           for(int i=0;i<size;i++){
            Integer node=queue.remove();
            course++;
            for(Integer it:adj.get(node)){
                ind[it]--;
                
                if(ind[it]==0){
                    queue.add(it);
                }
            }
           }
        }
        return course==n?semester:-1;

    }
}