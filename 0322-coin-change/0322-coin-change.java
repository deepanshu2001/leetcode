class Solution {
    public int f(int ind,int amount,int []coins,int dp[][]){
        if(ind>=coins.length){
            return (int)Math.pow(10,9);
        }
        if(amount==0){
            return 0;
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int nottake=f(ind+1,amount,coins,dp);
        int take=(int)Math.pow(10, 9);
        if(coins[ind]<=amount){
            take=1+f(ind,amount-coins[ind],coins,dp);
        }
        return dp[ind][amount]=Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
         int dp[][]=new int[coins.length+1][amount+1];
         for(int i=0;i<=amount;i++){
            dp[coins.length][i]=(int)Math.pow(10,9);
         }
         for(int i=0;i<=coins.length;i++){
            dp[i][0]=0;
         }
         for(int i=coins.length-1;i>=0;i--){
            for(int amu=0;amu<=amount;amu++){
                int nottake=dp[i+1][amu];
                int take=(int)Math.pow(10, 9);
                if(coins[i]<=amu){
                    take=1+dp[i][amu-coins[i]];
                }
                dp[i][amu]=Math.min(take,nottake);
            }
         }
        int ans=dp[0][amount];
       
       
        if(ans==Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
}