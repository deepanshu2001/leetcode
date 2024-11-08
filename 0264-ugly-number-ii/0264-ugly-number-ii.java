class Solution {
    public int nthUglyNumber(int n) {
        int cnt=1;
        for(int i=2;i<=1690;i++){
            if(i%2==0||i%3==0||i%5==0){
                cnt++;
                if(cnt==n){
                    if(n%2==1){
                        return i+1;
                    }
                    return i;
                }
            }
        }
       
        return n;
    }
}