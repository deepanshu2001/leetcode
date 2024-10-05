class Solution {
    public int f(int ind,int buy,int prices[],int fee){
        if(ind==prices.length){
            return 0;
        }
        int profit=0;
        if(buy==1){
            profit=Math.max(-prices[ind]+f(ind+1,0,prices,fee),f(ind+1,1,prices,fee));
        }
        else{
            profit=Math.max(prices[ind]-fee+f(ind+1,1,prices,fee),f(ind+1,0,prices,fee));
        }
        return profit;
    }
    public int maxProfit(int[] prices, int fee) {
        return f(0,1,prices,fee);
    }
}