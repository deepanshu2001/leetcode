class Solution {
    public int f(int start, String s, int[] dp, int n, Set<String> set) {
        if (start >= n) {
            return 0;
        }
        if (dp[start] != -1) {
            return dp[start];
        }
        int min_extra = Integer.MAX_VALUE;
        String curr_str = "";
        for (int i = start; i < n; i++) {
            curr_str += s.charAt(i);
            int curr_extra = set.contains(curr_str) ? 0 : curr_str.length();
            int next_extra = f(i + 1, s, dp, n, set);
            min_extra = Math.min(min_extra, curr_extra + next_extra);
        }
        return dp[start] = min_extra;
    }
    
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        int dp[] = new int[s.length()];
        Arrays.fill(dp, -1);
        return f(0, s, dp, s.length(), set);
    }
}
