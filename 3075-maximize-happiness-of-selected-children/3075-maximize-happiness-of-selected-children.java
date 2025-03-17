class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        long ans=0;
        Arrays.sort(happiness);
        int ind=happiness.length-1;
        for(int j=0;j<k;j++){
            ans+=happiness[ind];
            for(int i=0;i<ind;i++){
                if(happiness[i]>0){
                    happiness[i]=happiness[i]-1;
                }
            }
            ind--;
        }
        return ans;
    }
}