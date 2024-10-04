class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int dp[][][]=new int[n+1][2][3];
        for(int ind=n-1;ind>=0;ind--){
            for(int buy=0;buy<=1;buy++){
                for(int c=1;c<=2;c++){
                    if(buy==1){
                        dp[ind][buy][c]=Math.max(-prices[ind]+dp[ind+1][0][c],0+dp[ind+1][1][c]);
                    }
                    else{
                        dp[ind][buy][c]=Math.max(prices[ind]+dp[ind+1][1][c-1],0+dp[ind+1][0][c]);
                    }
                }
            }
        }
        return dp[0][1][2];
    }
}