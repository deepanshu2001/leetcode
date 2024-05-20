//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public void dfs(ArrayList<ArrayList<Integer>> adj,int vis[],int node,Stack<Integer> st){
        vis[node]=1;
        for(Integer it:adj.get(node)){
            if(vis[it]==0){
                dfs(adj,vis,it,st);
            }
        }
        st.push(node);
    }
    public void d(int node,int []vis,ArrayList<ArrayList<Integer>> adjT){
        vis[node]=1;
        for(Integer it:adjT.get(node)){
            if(vis[it]==0){
                d(it,vis,adjT);
            }
        }
    }
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        int ans=0;
        Stack<Integer>st=new Stack<>();
        //step 1 sort all the edges according to finishing time
        int vis[]=new int[V];
        for(int i=0;i<V;i++){
            if(vis[i]==0){
                dfs(adj,vis,i,st);
            }
        }
        //step 2 reverse the edges
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
        for(int i=0;i<V;i++){
            adjT.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            vis[i]=0;
            for(Integer it:adj.get(i)){
                adjT.get(it).add(i);
            }
        }
        //do dfs
        while(!st.isEmpty()){
            int node=st.pop();
            if(vis[node]==0){
                ans++;
                d(node,vis,adjT);
            }
            
        }
        return ans;
    }
}
