class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full_bottles=numBottles;
        int empty_bottles=0;
        int drunk=0;
        while(full_bottles!=0 || empty_bottles>=numExchange){
            if(empty_bottles>=numExchange){
                empty_bottles-=numExchange;
                numExchange++;
                full_bottles++;
            }
            else{
                empty_bottles+=full_bottles;
                drunk+=full_bottles;
                full_bottles=0;
            }
        }
        return drunk;
    }
}