//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S[] = read.readLine().split(" ");
            int R = Integer.parseInt(S[0]);
            int C = Integer.parseInt(S[1]);
            int matrix[][] = new int[R][C];
            int c = 0;
            for(int i = 0; i < R; i++){
                String line[]=read.readLine().trim().split(" ");
                for(int j = 0; j < C; j++){
                    matrix[i][j] = Integer.parseInt(line[j]);
                }
            }
            Solution ob = new Solution();
            int ans = ob.median(matrix, R, C);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public int helper(int [][]arr,int target){
        int cnt=0;
        for(int row[]:arr){
            int s=0;
            int e=row.length-1;
            while(s<=e){
                int mid=s+(e-s)/2;
                if(row[mid]<=target){
                    s=mid+1;
                }
                else if(row[mid]>target){
                    e=mid-1;
                }
            }
            cnt+=s;
        }
        return cnt;
    }
    int median(int matrix[][], int R, int C) {
        // code here     
        int s=Integer.MAX_VALUE;
        int e=Integer.MIN_VALUE;
        for(int i=0;i<R;i++){
            s=Math.min(s,matrix[i][0]);
        }
        for(int i=0;i<R;i++){
            e=Math.max(e,matrix[i][C-1]);
        }
        int req=(R*C)/2;
        while(s<=e){
            int mid=s+(e-s)/2;
            int cnt=helper(matrix,mid);
            if(cnt<=req){
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return s;
    }
}