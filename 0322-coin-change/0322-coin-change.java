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
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=f(0,amount,coins,dp);
       
       
        if(ans==Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
}