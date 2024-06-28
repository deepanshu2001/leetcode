class Solution {
    public int arrangeCoins(int n) {
       if(n<=1){
        return n;
       }
       long s=1;
       long e=n;
       while(s<=e){
         long mid=s+(e-s)/2;
         long target=(mid*(mid+1))/2;
         if(target<n){
            s=mid+1;
         }
         else if(target>n){
            e=mid-1;
         }
         
       }
       return (int)e; 
    }
}