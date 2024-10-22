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
        int cnt=0;
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0){
              q.add(i);
            }
        }
        while(!q.isEmpty()){
            Integer node=q.remove();
            cnt++;
            for(Integer it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    q.add(it);
                }
            }
        }
        if(cnt<numCourses){
            return false;
        }
        return true;
    }
}