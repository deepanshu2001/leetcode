class Solution {
    public int kthFactor(int n, int k) {
        int ans=-1;
        int cnt=0;
        for(int i=1;i<=n;i++){
            if(n%i==0){
                cnt++;
                if(cnt==k){
                   ans=i;
                   break;
                }
            }
        }
        if(cnt<k){
            return -1;
        }
        return ans;
    }
}