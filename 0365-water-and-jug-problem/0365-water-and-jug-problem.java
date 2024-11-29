class Solution {
    public int GCD(int a,int b){
        while(b!=0){
            int temp=b;
            b=a%b;
            a=temp;
        }
        return a;
    }
    public boolean canMeasureWater(int x, int y, int target) {
        if(x+y==target){
            return true;
        }
        if(x+y<target){
            return false;
        }
        return target%GCD(x,y)==0;
    }
}