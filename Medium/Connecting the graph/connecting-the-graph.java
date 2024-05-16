//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class DisjointSet {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int Upar=findUPar(parent.get(node));
        parent.set(node,Upar);
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
class Solution {

    public int Solve(int n, int[][] edge) {
        int N=edge.length;
        
        DisjointSet ds=new DisjointSet(n);
        int cnt=0;
        // Code here
        for(int i=0;i<N;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            if(ds.findUPar(u)!=ds.findUPar(v)){
                ds.unionBySize(u,v);
            }
            else{
                cnt++;
            }
        }
        int ans=0;
        
        for(int i=0;i<n;i++){
            
            if(ds.findUPar(i)==i){
                ans++;
            }
        }
        ans=ans-1;
        if(cnt>=ans){
            return ans;
        }
        return -1;
        
    }
}