class Solution {
   
    public int maxProfit(int[] prices) {
        int dp[][]=new int[prices.length+1][2];
        
        int n=prices.length;
        int ahead[]=new int[2];
        int curr[]=new int[2];
        ahead[0]=0;
        ahead[1]=0;
        int profit=0;
        for(int i=n-1;i>=0;i--){
           
            for(int buy=0;buy<=1;buy++){
              if(buy==1){
                profit=Math.max(-prices[i]+ahead[0],ahead[1]);
              }
              else{
                profit=Math.max(prices[i]+ahead[1],ahead[0]);
              }
              curr[buy]=profit;
              
            }
            System.arraycopy(curr,0,ahead,0,2);
        }

        return curr[1];
    }
}