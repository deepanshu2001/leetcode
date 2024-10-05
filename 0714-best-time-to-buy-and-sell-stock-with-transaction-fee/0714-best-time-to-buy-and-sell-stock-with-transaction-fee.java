class Solution {
    public int f(int ind,int buy,int prices[],int fee,int dp[][]){
        if(ind==prices.length){
            return 0;
        }
        if(dp[ind][buy]!=-1){
            return dp[ind][buy];
        }
        int profit=0;
        if(buy==1){
            
        }
        else{
            
        }
        return dp[ind][buy]=profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n=prices.length;
        int dp[][]=new int[prices.length+1][2];
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                if(buy==0){
                   dp[i][buy]=Math.max(prices[i]-fee+dp[i+1][1],dp[i+1][0]);
                }
                else{
                   dp[i][buy]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
                }
            }
        }
        return dp[0][1];
    }
}