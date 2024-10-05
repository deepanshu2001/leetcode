class Solution {
    public int f(int nums[],int ind,int sum,int target){
        if(ind==nums.length){
            if(sum==target){
                return 1;
            }
            return 0;
        }
        int plus=f(nums,ind+1,sum+nums[ind],target);
        int minus=f(nums,ind+1,sum-nums[ind],target);
        return plus+minus;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return f(nums,0,0,target);
    }
}