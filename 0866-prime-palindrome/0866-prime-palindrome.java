class Solution {
    public boolean isPrime(int num){
        for(int i=2;i<=num/2;i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
    public boolean is_palindrome(int num){
        String s=Integer.toString(num);
        int i=0;
        int j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
    public int primePalindrome(int n) {
        if(n==1){
            return 2;
        }
        for(int i=n;i<Integer.MAX_VALUE;i++){
            if(isPrime(i) && is_palindrome(i)){
                return i;
            }
        }
        return -1;
    }
}