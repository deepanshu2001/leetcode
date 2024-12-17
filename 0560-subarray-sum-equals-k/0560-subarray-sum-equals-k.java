class Solution {
    public int subarraySum(int[] nums, int k) {
        int cnt=0;
        int j=0;
        int sum=0;
        int i=0;
        while(j<nums.length){
            sum+=nums[j];
            if(sum==k){
                cnt++;
                
            }
            while(sum>k){
                sum-=nums[i];
                if(i<j && sum==k){
                    cnt++;
                }
                i++;
            }
            j++;
        }
        return cnt;
    }
}