class Solution {
    public boolean f(int ind, int target, int nums[], int dp[][]) {

        if(target == 0){
            return true;
        }

        if(ind == 0){
            return target == nums[0];
        }

        if(dp[ind][target] != -1){
            return dp[ind][target] == 1;
        }

        boolean not_take = f(ind - 1, target, nums, dp);

        boolean take = false;

        if(target >= nums[ind]){
            take = f(ind - 1, target - nums[ind], nums, dp);
        }

        dp[ind][target] = (take || not_take) ? 1 : 0;

        return take || not_take;
    }

    public boolean canPartition(int[] nums) {

        int total_sum = 0;

        for(int num : nums){
            total_sum += num;
        }

        if(total_sum % 2 != 0){
            return false;
        }

        int sum = total_sum / 2;

        int dp[][] = new int[nums.length][sum + 1];

        for(int row[] : dp){
            Arrays.fill(row, -1);
        }

        return f(nums.length - 1, sum, nums, dp);
    }
}