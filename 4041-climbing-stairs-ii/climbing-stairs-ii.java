class Solution {

    public int f(int i, int[] costs, int[] dp) {

        if (i == 0) {
            return 0;
        }

        if (dp[i] != -1) {
            return dp[i];
        }

        int ans = Integer.MAX_VALUE;

        if (i >= 1) {
            ans = Math.min(
                ans,
                f(i - 1, costs, dp) + costs[i - 1] + 1
            );
        }

        if (i >= 2) {
            ans = Math.min(
                ans,
                f(i - 2, costs, dp) + costs[i - 1] + 4
            );
        }

        if (i >= 3) {
            ans = Math.min(
                ans,
                f(i - 3, costs, dp) + costs[i - 1] + 9
            );
        }

        return dp[i] = ans;
    }

    public int climbStairs(int n, int[] costs) {

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);

        return f(n, costs, dp);
    }
}