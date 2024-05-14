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
class DisjointSet{
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    List<Integer> parent=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            size.add(1);
            rank.add(0);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int upar=findUPar(parent.get(node));
        parent.set(node,upar);
        return parent.get(node);
    }
    public void unionByRank(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(rank.get(up)<rank.get(vp)){
            parent.set(up,vp);
        }
        else if(rank.get(vp)<rank.get(up)){
            parent.set(vp,up);
        }
        else{
            parent.set(vp,up);
            int rankU=rank.get(up);
            rank.set(up,rankU+1);
        }
    }
    public void unionBySize(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(size.get(up)<size.get(vp)){
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }
        else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}
class Edge implements Comparable<Edge> {
    int src, dst, wt;
    Edge(int _src, int _dst, int _wt) {
        this.src = _src; this.dst = _dst; this.wt = _wt;
    }
    // Comparator function used for
    // sorting edgesbased on their weight
    public int compareTo(Edge compareEdge) {
        return this.wt - compareEdge.wt;
    }
};
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        List<Edge> edges=new ArrayList<Edge>();
        for(int i=0;i<V;i++){
            for(int j=0;j<adj.get(i).size();j++){
                int adjnode=adj.get(i).get(j)[0];
                int adjwt=adj.get(i).get(j)[1];
                int node=i;
                Edge temp=new Edge(i,adjnode,adjwt);
                edges.add(temp);
            }
        }
        Collections.sort(edges);
        DisjointSet ds=new DisjointSet(V);
        int sum=0;
        for(int i=0;i<edges.size();i++){
            int wt=edges.get(i).wt;
            int u=edges.get(i).src;
            int v=edges.get(i).dst;
            if(ds.findUPar(u)!=ds.findUPar(v)){
                sum+=wt;
                ds.unionBySize(u,v);
            }
        }
        return sum;
    }
}