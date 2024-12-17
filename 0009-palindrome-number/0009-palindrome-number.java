class Solution {
    public boolean isPalindrome(int x) {
        if(x==0){
            return true;
        }
        if(x<0||x%10==0){
            return false;
        }
        
        int reverse=0;
        int num=x;
        while(num>0){
            int rem=num%10;
            reverse=reverse*10+rem;
            num=num/10;
        }
        return reverse==x;
    }
}