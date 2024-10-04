class Solution {
    public boolean isPalindrome(int x) {
        if(x<0||x%10==0 && x!=0){
            return false;
        }
        int reverse=0;
        while(x>reverse){
            int rem=x%10;
            reverse=reverse*10+rem;
            
            x=x/10;
        }
        if(x==reverse){
            return true;
        }
        else{
            x=x*10+reverse%10;
            if(x==reverse){
                return true;
            }
        }
        return false;
    }

}