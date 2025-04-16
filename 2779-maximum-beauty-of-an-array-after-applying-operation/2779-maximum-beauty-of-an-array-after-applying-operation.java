class Solution {
    public int maximumBeauty(int[] nums, int k) {
        Arrays.sort(nums);
        int ans=0;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]-nums[i]<=2*k){
                    ans=Math.max(j-i+1,ans);
                }
            }
        }
        return ans;
    }
}