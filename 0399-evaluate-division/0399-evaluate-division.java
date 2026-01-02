class Solution {
    class Pair{
        String first;
        double second;
        Pair(String first,double second){
            this.first=first;
            this.second=second;
        }

    }
    public double dfs(String u,String v,Map<String,List<Pair>> adj,double currval,Set<String> set){
        if(u.equals(v)){
            return currval;
        }
        set.add(u);
        for(Pair pair:adj.get(u)){
           if(!set.contains(pair.first)){
               double result=dfs(pair.first,v,adj,currval*pair.second,set);
               if(result!=-1.0){
                return result;
               }
           }
        }
        return -1.0;

    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String,List<Pair>> adj=new HashMap<>();
        for(int i=0;i<equations.size();i++){
            String u=equations.get(i).get(0);
            String v=equations.get(i).get(1);
            adj.putIfAbsent(u, new ArrayList<>());
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(u).add(new Pair(v,values[i]));
            adj.get(v).add(new Pair(u,1/values[i]));
        }
        double[] ans=new double[queries.size()];
        for(int i=0;i<queries.size();i++){
            String u=queries.get(i).get(0);
            String v=queries.get(i).get(1);
            if(!adj.containsKey(u)|| !adj.containsKey(v)){
                ans[i]=-1.0;
            }
            else{
                ans[i]=dfs(u,v,adj,1.0,new HashSet<>());
            }
        }
        return ans;
    }
}