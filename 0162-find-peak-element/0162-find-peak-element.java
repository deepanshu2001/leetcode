class Solution {
    public int findPeakElement(int[] arr) {
        if(arr.length<2 || arr[0]>arr[1]){
            return 0;
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        int s=0;
        int e=arr.length-1;
        while(s<e){
           int mid=s+(e-s)/2;
           if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
            return mid;
           }
           else if(arr[mid]>arr[mid+1]){
             e=mid-1;
           }
           else{
             s=mid+1;
           }
        }
        return s;
    }
}