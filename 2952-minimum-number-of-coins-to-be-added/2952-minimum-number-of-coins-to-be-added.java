class Solution {
    public int minimumAddedCoins(int[] coins, int target) {
        int max=0;
        int add=0;
        int ind=0;
        Arrays.sort(coins);
        while(max<target){
            if(ind<coins.length && coins[ind]<=max+1){
                max+=coins[ind];
                ind++;
            }
            else{
                max+=max+1;
                add++;
            }
        }
        return add;
    }
}