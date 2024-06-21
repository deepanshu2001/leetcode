class Solution {
    public int func(int nums[],int k){
        int i=0;
        int j=0;
        int cnt=0;
        int sum=0;
        if(k<0){
            return 0;
        }
        while(j<nums.length){
            sum+=(nums[j])%2;
            while(sum>k){
                sum-=(nums[i])%2;
                i++;
            }
            cnt+=j-i+1;
            j++;
        }
        return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
       return func(nums,k)-func(nums,k-1);
    }
}