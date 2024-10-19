class Solution {
    public int f(int coins[],int amount,int ind,int dp[][]){
         //nottake
         if(amount==0){
            return 0;
         }
         if(ind>=coins.length){
            return (int)Math.pow(10,9);
         }
         if(dp[amount][ind]!=-1){
            return dp[amount][ind];
         }
         int notake=0+f(coins,amount,ind+1,dp);
         int take=(int)Math.pow(10,9);
         if(coins[ind]<=amount){
            take=1+f(coins,amount-coins[ind],ind,dp);
         }
         return dp[amount][ind]=Math.min(take,notake);
    }
    public int coinChange(int[] coins, int amount) {
         int dp[][]=new int[amount+1][coins.length+1];
         for(int row[]:dp){
            Arrays.fill(row,-1);
         }
        int ans=f(coins,amount,0,dp);
       
        if(ans==(int)Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
}