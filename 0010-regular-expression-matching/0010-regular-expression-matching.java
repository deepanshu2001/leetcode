class Solution {
    public boolean solve(String s, String p, int i, int j, Boolean[][] memo) {
        // Base case
        if (j == p.length()) {
            return i == s.length();
        }

        // Check memoization
        if (memo[i][j] != null) {
            return memo[i][j];
        }

        boolean flag = (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.'));

        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            boolean notake = solve(s, p, i, j + 2, memo); // Skip the '*' pattern
            boolean take = flag && solve(s, p, i + 1, j, memo); // Use the current character
            memo[i][j] = take || notake; // Store the result in memo
        } else {
            memo[i][j] = flag && solve(s, p, i + 1, j + 1, memo); // Move both pointers
        }

        return memo[i][j];
    }

    public boolean isMatch(String s, String p) {
        Boolean[][] memo = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0, memo);
    }
}
