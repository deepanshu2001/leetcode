//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][3];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
                edge[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res[] = obj.shortestPath(n, m, edge);
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    Stack<Integer> st=new Stack<>();
    public void dfs(ArrayList<ArrayList<Pair>> adj,int node,int []vis){
        vis[node]=1;
        for(Pair pair:adj.get(node)){
            int v=pair.first;
            int wt=pair.second;
            if(vis[v]==0){
                dfs(adj,v,vis);
            }
        }
        st.push(node);
    }
    public int[] shortestPath(int V, int E, int[][] edges) {
        // Code here
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            ArrayList<Pair> temp=new  ArrayList<>();
            adj.add(temp);
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,i,vis);
            }
        }
        int dist[]=new int[V];
        for(int i=0;i<V;i++){
            dist[i]=(int)1e9;
        }
        dist[0]=0;
        while(!st.isEmpty()){
            Integer node=st.pop();
            int distance=dist[node];
            for(Pair p:adj.get(node)){
                int v=p.first;
                int wt=p.second;
                if(distance+wt<dist[v]){
                    dist[v]=distance+wt;
                }
            }
        }
        for(int i=0;i<V;i++){
            if(dist[i]==1e9){
                dist[i]=-1;
            }
        }
        return dist;
    }
}