public class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long arr[][] = new long[26][26];
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                arr[i][j] = Long.MAX_VALUE;
                if (i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < original.length; i++) {
            int val1 = original[i] - 'a';
            int val2 = changed[i] - 'a';
            arr[val1][val2] = Math.min(arr[val1][val2], cost[i]);
        }

        for (int k = 0; k < 26; k++) {
            for (int i = 0; i < 26; i++) {
                for (int j = 0; j < 26; j++) {
                    if (arr[i][k] < Long.MAX_VALUE && arr[k][j] < Long.MAX_VALUE) {
                        arr[i][j] = Math.min(arr[i][j], arr[i][k] + arr[k][j]);
                    }
                }
            }
        }

        if (source.length() != target.length()) {
            return -1L;
        }

        long ans = 0;
        for (int i = 0; i < source.length(); i++) {
            int val1 = source.charAt(i) - 'a';
            int val2 = target.charAt(i) - 'a';
            if (arr[val1][val2] == Long.MAX_VALUE) {
                return -1L;
            }
            ans += arr[val1][val2];
        }
        
        return ans;
    }
}
