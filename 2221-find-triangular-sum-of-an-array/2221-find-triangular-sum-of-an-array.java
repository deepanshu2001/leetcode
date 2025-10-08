class Solution {
    public int findsum(int []nums,int n){
        if(n==1){
            return nums[0];
        }
        for(int i=0;i<n-1;i++){
            nums[i]=(nums[i]+nums[i+1])%10;
        }
        return findsum(nums,n-1);
    }
    public int triangularSum(int[] nums) {
        int n=nums.length;
        return findsum(nums,n);
    }
}