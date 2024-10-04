class Solution {
    
    public int maxProfit(int k, int[] prices) {
        
        int dp[][][]=new int[prices.length+1][2][k+1];
        int n=prices.length;
       
        for(int i=n-1;i>=0;i--){
            for(int buy=0;buy<=1;buy++){
                for(int target=1;target<=k;target++){
                    if(buy==1){
                        dp[i][buy][target]=Math.max(-prices[i]+dp[i+1][0][target],0+dp[i+1][1][target]);
                    }
                    else{
                        dp[i][buy][target]=Math.max(prices[i]+dp[i+1][1][target-1],0+dp[i+1][0][target]);
                    }
                }
            }
        }
        return dp[0][1][k];
    }
}