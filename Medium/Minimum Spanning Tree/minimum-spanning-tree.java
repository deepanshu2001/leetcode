//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        int vis[]=new int[V];
        int ans=0;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        while(pq.size()!=0){
            Pair pair=pq.remove();
            int wt=pair.first;
            int node=pair.second;
            if(vis[node]==1){
                continue;
            }
            vis[node]=1;
            ans+=wt;
            for(int i=0;i<adj.get(node).size();i++){
                int adjnode=adj.get(node).get(i)[0];
                int adjwt=adj.get(node).get(i)[1];
                if(vis[adjnode]==0){
                    pq.add(new Pair(adjwt,adjnode));
                }
                
            }
            
        }
        return ans;
    }
}