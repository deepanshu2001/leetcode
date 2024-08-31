//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends


class Solution {
    public void helper(int[][] mat,ArrayList<String> ans,String p,int row,int col,int [][]vis){
        int n=mat.length;
        if(row==n-1 && col==n-1){
            ans.add(p);
            return;
        }
        
        vis[row][col]=1;
        //up
        if(row>0 && mat[row-1][col]==1 && vis[row-1][col]==0){
            helper(mat,ans,p+'U',row-1,col,vis);
        }
        //right;
        if(col<n-1 && mat[row][col+1]==1 && vis[row][col+1]==0){
            helper(mat,ans,p+'R',row,col+1,vis);
        }
        //down
        if(row<n-1 && mat[row+1][col]==1 && vis[row+1][col]==0){
            helper(mat,ans,p+'D',row+1,col,vis);
        }
        //Left
        if(col>0 && mat[row][col-1]==1 && vis[row][col-1]==0){
            helper(mat,ans,p+'L',row,col-1,vis);
        }
        vis[row][col]=0;
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> ans=new ArrayList<>();
        if(mat[0][0]==0){
            return ans;
        }
        String p="";
        int n=mat.length;
        int vis[][]=new int[n][n];
        helper(mat,ans,p,0,0,vis);
        return ans;
    }
}