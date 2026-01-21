class Solution {
    public int minFallingPathSum(int[][] grid) {
    int n = grid.length;
    int ans = (int)1e9;
    int[][] dp = new int[n][n];

    for (int j = 0; j < n; j++) {
        dp[n - 1][j] = grid[n - 1][j];
    }

    for (int i = n - 2; i >= 0; i--) {
        for (int j = 0; j < n; j++) {
            int min = (int)1e9;
            for (int k = 0; k < n; k++) {
                if (k != j) {
                    min = Math.min(min, dp[i + 1][k]);
                }
            }
            dp[i][j] = grid[i][j] + min;
        }
    }

    for (int j = 0; j < n; j++) {
        ans = Math.min(ans, dp[0][j]);
    }

    return ans;
}

}