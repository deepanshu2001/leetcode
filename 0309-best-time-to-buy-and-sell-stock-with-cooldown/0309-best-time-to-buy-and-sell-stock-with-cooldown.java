class Solution {
    public int f(int ind,int buy,int []prices,int dp[][]){
        if(ind>=prices.length){
            return 0;
        }
        int profit=0;
        //can buy
        if(buy==1){
          profit=Math.max(-prices[ind]+f(ind+1,0,prices,dp),f(ind+1,1,prices,dp));
        }
        else{
            profit=Math.max(prices[ind]+f(ind+2,1,prices,dp),f(ind+1,0,prices,dp));
        }
        return dp[ind][buy]=profit;
    
    }
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length+2][2];
        int n=prices.length;
        for(int i=n-1;i>=0;i--){
           for(int buy=0;buy<=1;buy++){
              if(buy==1){
                dp[i][buy]=Math.max(-prices[i]+dp[i+1][0],dp[i+1][1]);
              }
              else{
                dp[i][buy]=Math.max(prices[i]+dp[i+2][1],dp[i+1][0]);
              }
           }
        }
        return dp[0][1];
    }
}