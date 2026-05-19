import java.util.*;

class Solution {
    public int f(int i, int j, int[] piles, int[][] dp) {
        if (i == j) {
            return piles[i];
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int pickLeft = piles[i] - f(i + 1, j, piles, dp);
        int pickRight = piles[j] - f(i, j - 1, piles, dp);

        return dp[i][j] = Math.max(pickLeft, pickRight);
    }

    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        return f(0, n - 1, piles, dp) > 0;
    }
}