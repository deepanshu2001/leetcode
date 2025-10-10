class Solution {
    public int[] getNoZeroIntegers(int n) {
        for(int i=1;i<n;i++){
            int a=i;
            int b=n-i;
            int n1=a;
            int n2=b;
            boolean flag=true;
            while(n1>0){
                int rem=n1%10;
                if(rem==0){
                   flag=false;
                   break;
                }
                n1=n1/10;
            }
            while(n2>0){
                int rem=n2%10;
                if(rem==0){
                   flag=false;
                   break;
                }
                n2=n2/10;
            }
            if(flag==true){
                return new int[]{a,b};
            }
        }
        return new int[]{0,0};
    }
}