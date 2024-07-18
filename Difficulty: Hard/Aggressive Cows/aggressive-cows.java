//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public static boolean is_possible(int arr[],int mid,int k ){
        int last=arr[0];
        int cnt=1;
        for(int i=0;i<arr.length;i++){
            if(arr[i]-last>=mid){
                cnt++;
                last=arr[i];
            }
            if(cnt>=k){
                return true;
            }
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        int ans=-1;
        Arrays.sort(stalls);
        int s=0;
        int e=stalls[stalls.length-1]-stalls[0];
        while(s<=e){
            int mid=s+(e-s)/2;
            if(is_possible(stalls,mid,k)){
                ans=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}