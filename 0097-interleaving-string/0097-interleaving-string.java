class Solution {
    public boolean f(String s1, String s2, String s3, int i, int j, int[][] dp) {
        int k = i + j;
        if (k == s3.length()) {
            return i == s1.length() && j == s2.length();
        }
        if (dp[i][j] != -1) {
            return dp[i][j] == 1;
        }
        boolean flag = false;
        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
            flag = f(s1, s2, s3, i + 1, j, dp);
        }
        if (!flag && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
            flag = f(s1, s2, s3, i, j + 1, dp);
        }
        dp[i][j] = flag ? 1 : 0;
        return flag;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        int n = s1.length(), m = s2.length();
        if (n + m != s3.length()) {
            return false;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return f(s1, s2, s3, 0, 0, dp);
    }
}
