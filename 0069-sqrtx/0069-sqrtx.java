class Solution {
    public int mySqrt(int x) {
        if(x<=1){
            return x;
        }
        int s=1;
        int e=x;
        int  ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(mid>x/mid){
                e=mid-1;
            }
            else if(mid<x/mid){
                ans=mid;
                s=mid+1;
            }
            else if(mid==x/mid){
                return mid;
            }
        }
        return (int)e;
    }
}