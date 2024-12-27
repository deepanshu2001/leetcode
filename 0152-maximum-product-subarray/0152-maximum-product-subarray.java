class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            int num=nums[i];
            ans=Math.max(num,ans);
            for(int j=i+1;j<nums.length;j++){
                num=num*nums[j];
                ans=Math.max(num,ans);
            }
        }
        return ans;
    }
}