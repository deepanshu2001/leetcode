import java.util.Arrays;

class Solution {
    int mod = 1000000007;

    public int f(int row, int col, int maxMove, int m, int n, int[][][] dp) {
        // Base cases
        if (row < 0 || col < 0 || row >= m || col >= n) {
            return 1; // Out of bounds
        }

        if (maxMove == 0) return 0;

        if (dp[row][col][maxMove] != -1) {
            return dp[row][col][maxMove];
        }

        long res = 0;
        res += f(row - 1, col, maxMove - 1, m, n, dp);
        res += f(row, col + 1, maxMove - 1, m, n, dp);
        res += f(row + 1, col, maxMove - 1, m, n, dp);
        res += f(row, col - 1, maxMove - 1, m, n, dp);

        dp[row][col][maxMove] = (int)(res % mod);
        return dp[row][col][maxMove];
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m][n][maxMove + 1];
        for (int[][] arr : dp) {
            for (int[] a : arr) {
                Arrays.fill(a, -1);
            }
        }
        return f(startRow, startColumn, maxMove, m, n, dp);
    }
}
