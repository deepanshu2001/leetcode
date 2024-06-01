class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans=Integer.MIN_VALUE;
        int l_sum=0;
        int i=0;
        while(i<k-1){
            l_sum+=cardPoints[i];
            i++;
        }
        l_sum+=cardPoints[i];
        ans=Math.max(ans,l_sum);
        int r_sum=0;
        int j=cardPoints.length-1;
        while(j>cardPoints.length-k-1){
            l_sum-=cardPoints[i];
            i--;
            r_sum+=cardPoints[j];
            ans=Math.max(ans,l_sum+r_sum);
            j--;
        }
        return ans;
    }
}