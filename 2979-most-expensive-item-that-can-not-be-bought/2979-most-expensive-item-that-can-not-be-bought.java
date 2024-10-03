class Solution {
    int max=0;
    public int mostExpensiveItem(int primeOne, int primeTwo) {
        int prod=primeOne*primeTwo;
        max=prod;
        int dp[]=new int[max];
        Arrays.fill(dp,-1);
        for(int i=max-1;i>=1;i--){
           
            if(!f(primeOne,primeTwo,i,dp)){
                return i;
            }
        }
        return -1;
    }
    public boolean f(int primeOne,int primeTwo,int target,int dp[]){
        if(target<0){
            return false;
        }
        if(target==0){
            return true;
        }
        if(dp[target]!=-1){
            return dp[target]==1?true:false;
        }
        boolean l1=f(primeOne, primeTwo, target-primeOne,dp);
        boolean l2=f(primeOne, primeTwo, target-primeTwo,dp);
        dp[target]=l1||l2?1:0;
        return l1||l2;
    }
}