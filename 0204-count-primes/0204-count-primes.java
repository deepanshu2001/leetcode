class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        int cnt=0;
        boolean prime[]=new boolean[n];
        for(int i=2;i<=Math.sqrt(n);i++){
            if(prime[i]==false){
                for(int j=i*i;j<n;j+=i){
                    prime[j]=true;
                }
            }
        }
        for(int i=2;i<n;i++){
            if(prime[i]==false){
                cnt++;
            }
        }
        return cnt;
    }
}