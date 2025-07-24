class Solution {
    public boolean check(int n){
        if(n==1||n==0){
            return true;
        }
        if(n%2==1){
            return false;
        }
        return check(n/2);
    }
    public boolean isPowerOfTwo(int n) {
        if(n<=0){
            return false;
        }
        return check(n);
    }
}