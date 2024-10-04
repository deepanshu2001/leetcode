class Solution {
    public int f(int ind,int buy,int k,int []prices){
        if(ind==prices.length||k==0){
            return 0;
        }
        int profit=0;
        //can buy
        if(buy==1){
          profit=Math.max(-prices[ind]+f(ind+1,0,k,prices),f(ind+1,1,k,prices));
        }
        else{
            profit=Math.max(prices[ind]+f(ind+1,1,k-1,prices),f(ind+1,0,k,prices));
        }
        return profit;
    }
    public int maxProfit(int k, int[] prices) {
        return f(0,1,k,prices);
    }
}