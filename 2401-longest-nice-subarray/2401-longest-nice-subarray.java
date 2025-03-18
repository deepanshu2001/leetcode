class Solution {
    public int longestNiceSubarray(int[] nums) {
        int ans=0;
        int i=0;
        int j=0;
        int sum=0;
        while(j<nums.length){
           while(i<j && (sum & nums[j])!=0){
            sum=sum^nums[i];
            i++;
           }
           sum|=nums[j];
           ans=Math.max(ans,j-i+1);
           j++;
        }
        return ans;
    }
}