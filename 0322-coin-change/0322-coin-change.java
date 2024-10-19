class Solution {
    public int f(int coins[],int amount,int ind){
         //nottake
         if(amount==0){
            return 0;
         }
         if(ind>=coins.length){
            return (int)Math.pow(10,9);
         }
         int notake=0+f(coins,amount,ind+1);
         int take=(int)Math.pow(10,9);
         if(coins[ind]<=amount){
            take=1+f(coins,amount-coins[ind],ind);
         }
         return Math.min(take,notake);
    }
    public int coinChange(int[] coins, int amount) {
        int ans=f(coins,amount,0);
        if(ans==(int)Math.pow(10,9)){
            return -1;
        }
        return ans;
    }
}