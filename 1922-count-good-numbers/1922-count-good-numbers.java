class Solution {
    public long Pow(long x,long y){
        if(y==0){
            return 1;
        }
        long p=Pow(x,y/2);
        return p*p*(y%2>0?x:1)%1000000007;
    }
    public int countGoodNumbers(long n) {
        return (int)(Pow(5,(n+1)/2)*Pow(4,n/2)%1000000007);
    }
}