class Solution {
    int ans=0;
    public int longestMonotonicSubarray(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int cnt=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]>nums[j-1]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            ans=Math.max(ans,cnt);
        }
        for(int i=0;i<nums.length;i++){
            int cnt=1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[j-1]){
                    cnt++;
                }
                else{
                    break;
                }
            }
            ans=Math.max(ans,cnt);
        }
        return ans;
    }
}