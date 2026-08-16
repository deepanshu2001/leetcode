class Solution {
    public int f(int ind,int coins[],int amount,int dp[][]){
        if(ind==0){
            if(amount%coins[0]==0){
                return amount/coins[0];
            }
            else{
                return (int)Math.pow(10,9);
            }
        }
        if(dp[ind][amount]!=-1){
            return dp[ind][amount];
        }
        int nottake=f(ind-1,coins,amount,dp);
        int take=(int)Math.pow(10,9);
        if(amount>=coins[ind]){
            take=1+f(ind,coins,amount-coins[ind],dp);
        }
        return dp[ind][amount]=Math.min(take,nottake);
    }
    public int coinChange(int[] coins, int amount) {
        int dp[][]=new int[coins.length+1][amount+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        int ans=f(coins.length-1,coins,amount,dp);
        if(ans==(int)Math.pow(10,9)){
           return -1;
        }
        return ans;
    }
}