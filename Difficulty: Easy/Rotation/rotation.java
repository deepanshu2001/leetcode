//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    int findMin(int nums[]){
        int s=0;
        int e=nums.length-1;
        int ans=Integer.MAX_VALUE;
        int index=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[s]<=nums[mid]){
                ans=Math.min(nums[s],ans);
                if(ans==nums[s]){
                    index=s;
                }
                s=mid+1;
            }
            else if(nums[mid]<=nums[e]){
                ans=Math.min(nums[mid],ans);
                if(ans==nums[mid]){
                    index=mid;
                }
                e=mid-1;
            }
        }
        return index;
    }
    int findKRotation(int arr[], int n) {
        // code here
        int target=findMin(arr);
        
        return target;
    }
}