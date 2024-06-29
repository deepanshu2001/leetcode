class Solution {
    public int bs(int arr[]){
        int s=0;
        int e=arr.length-1;
        int cnt=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(arr[mid]>=0){
                s=mid+1;
            }
            else if(arr[mid]<0){
                cnt++;
                while(s<mid){
                    if(arr[s]<0){
                        cnt++;
                    }
                    s++;
                }
                s=mid+1;

            }
        }
        return cnt;
    }
    public int countNegatives(int[][] grid) {
        int ans=0;
        for(int []arr:grid){
           ans+=bs(arr);
        }
        return ans;
    }
}