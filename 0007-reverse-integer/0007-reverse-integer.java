class Solution {
    public int reverse(int x) {
        long ans=0;
        boolean neg=false;
        if(x<0){
            neg=true;
             x=x*(-1);
        }
       
        while(x>0){
            int rem=x%10;
            ans=ans*10+rem;
            x=x/10;
        }
         if(neg==true){
            ans=ans*(-1);
        }
        if(ans>Integer.MAX_VALUE||ans<Integer.MIN_VALUE){
            return 0;
        }
        
        return (int)(ans);
    }
}