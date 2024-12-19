class Solution {
    public int reverse(int x) {
        int sign=1;
        if(x<0){
            sign=-1;
            x=x*-1;
        }
        
        long new_num=0;
        while(x>0){
            int rem=x%10;
            new_num=new_num*10+rem;
            
            x=x/10;
        }
        if(sign==-1){
            new_num=new_num*-1;
        }
        if(new_num>Integer.MAX_VALUE||new_num<Integer.MIN_VALUE){
            return 0;
        }
        return (int)new_num;
    }
}