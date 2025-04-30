class Solution {
    public long countSubarrays(int[] nums, int k) {
        long ans=0;
        long cnt=0;
        int max=-1;
        for(int n=0;n<nums.length;n++){
            max=Math.max(max,nums[n]);
        }
        int i=0;
        int j=0;
        while(j<nums.length){
            if(nums[j]==max){
                cnt++;
            }
            while(cnt>=k){
                ans+=nums.length-j;
                if(nums[i]==max){
                    cnt--;
                }
                
                i++;
            }
            j++;
        }
        return ans;
    }
}