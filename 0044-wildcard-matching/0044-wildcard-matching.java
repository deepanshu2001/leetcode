class Solution {
    public boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        // Base case: both the pattern and the string are fully matched
        if (i == s.length() && j == p.length()) {
            return true;
        }
        // If pattern is exhausted but string is not
        if (j == p.length()) {
            return false;
        }
        // Memoization check
        if (dp[i][j] != null) {
            return dp[i][j];
        }
        boolean match = false;
        if (j < p.length()) {
            if (i < s.length() && (p.charAt(j) == s.charAt(i) || p.charAt(j) == '?')) {
                // Current characters match, proceed to next characters
                match = solve(s, p, i + 1, j + 1, dp);
            } else if (p.charAt(j) == '*') {
                // '*' can match zero or more characters
                // Try two possibilities:
                // 1. '*' matches zero characters (move to next pattern character)
                // 2. '*' matches one character (move to next string character)
                match = solve(s, p, i, j + 1, dp) || (i < s.length() && solve(s, p, i + 1, j, dp));
            } else {
                // Characters do not match
                match = false;
            }
        }
        dp[i][j] = match;
        return match;
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0, dp);
    }
}
