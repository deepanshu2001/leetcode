class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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
        
        int ans[]=new int[numCourses];
        int ind=numCourses-1;
        int cnt=0;
        while(!queue.isEmpty()){
            int node=queue.remove();
            ans[ind--]=node;
            cnt++;
            for(int it:adj.get(node)){
                indegree[it]--;
                if(indegree[it]==0){
                    queue.add(it);
                }
            }
        }
        if(cnt<numCourses){
            return new int[];
        }
        return ans;
    }
}