class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int s=0;
        int e=Integer.MAX_VALUE;
        while(s<e){
            int mid=s+(e-s)/2;
            if(check(mid,price,k)){
                s=mid+1;
            }
            else{
                e=mid;
            }
        }
        return s-1;
    }
    public boolean check(int x,int[]price,int k){
        int cnt=1;
        int i=1;
        int last=price[0];
        while(cnt<k && i<price.length){
            if(price[i]-last>=x){
                last=price[i];
                cnt++;
            }
            i++;
        }
        return cnt==k;
    }
}