class Solution {
    public int f(int ind,int buy,int trans,int []prices){
        if(ind==prices.length||trans==0){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+f(ind+1,0,trans,prices),f(ind+1,1,trans,prices));
        }
        else{
            profit=Math.max(prices[ind]+f(ind+1,1,trans-1,prices),f(ind+1,0,trans,prices));
        }
        return profit;
    }
    public int maxProfit(int[] prices) {
        return f(0,1,2,prices);
    }
}