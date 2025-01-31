class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int row[]:prerequisites){
            adj.get(row[0]).add(row[1]);
        }
        int indegree[]=new int[numCourses];
        for(int i=0;i<numCourses;i++){
            for(Integer it:adj.get(i)){
                indegree[it]++;
            }
        }
        Queue<Integer> queue=new LinkedList<>();
         for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
                queue.add(i);
            }
        }
        List<Integer> list=new ArrayList<>();
        while(!queue.isEmpty()){
            int node=queue.remove();
            list.add(node);
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }
        if(list.size()<numCourses){
            return false;
        }
        return true;
    }
}