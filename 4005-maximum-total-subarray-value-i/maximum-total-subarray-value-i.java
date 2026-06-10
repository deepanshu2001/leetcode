class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long ans=0;
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        while(k!=0){
            ans+=max-min;
            k--;
        }
        return ans;
    }
}