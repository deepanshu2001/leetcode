class Solution {
    public boolean f(int n,int power){
        if(n==0){
            return true;
        }
        int val=(int)Math.pow(3,power);
        if(val>n){
            return false;
        }
        boolean take=false;
        if(n>=val){
            take=f(n-val,power+1);
        }
        boolean nottake=f(n,power+1);
        return take||nottake;
        
    }
    public boolean checkPowersOfThree(int n) {
        return f(n,0);
    }
}