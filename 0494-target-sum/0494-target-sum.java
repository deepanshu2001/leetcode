class Solution {
    public int helper(int nums[],int target,int sum,int index){
        if(sum==target && index==nums.length){
            return 1;
        }
        if(index==nums.length && sum!=target){
            return 0;
        }
        int left=helper(nums,target,sum+nums[index],index+1);
        int right=helper(nums,target,sum-nums[index],index+1);
        return left+right;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums,target,0,0);
    }
}