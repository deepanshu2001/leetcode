class Solution {
    public int f(String s,int ind,int prev){
        if(ind>=s.length()){
            return 0;
        }
        int flip=Integer.MAX_VALUE;
        int notFlip=Integer.MAX_VALUE;
        if(s.charAt(ind)=='0'){
            if(prev==0){
                flip=1+f(s,ind+1,1);
                notFlip=0+f(s,ind+1,0);
            }
            else{
                flip=1+f(s,ind+1,1);
            }
        }
        else{
            if(prev==0){
                flip=1+f(s,ind+1,0);
                notFlip=0+f(s,ind+1,1);
            }
            else{
                notFlip=0+f(s,ind+1,1);
            }
        }
        return Math.min(flip,notFlip);
    }
    public int minFlipsMonoIncr(String s) {
        return f(s,0,0);
    }
}