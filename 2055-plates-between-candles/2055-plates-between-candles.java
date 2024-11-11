public class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] prefixSum = new int[n];
        int[] nearestLeftCandle = new int[n];
        int[] nearestRightCandle = new int[n];
        int[] result = new int[queries.length];

        // Build prefix sum of plates
        int plates = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') {
                plates++;
            }
            prefixSum[i] = plates;
        }

        // Build nearest left candle indices
        int leftCandle = -1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '|') {
                leftCandle = i;
            }
            nearestLeftCandle[i] = leftCandle;
        }

        // Build nearest right candle indices
        int rightCandle = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                rightCandle = i;
            }
            nearestRightCandle[i] = rightCandle;
        }

        // Answer queries
        for (int i = 0; i < queries.length; i++) {
            int left = nearestRightCandle[queries[i][0]];
            int right = nearestLeftCandle[queries[i][1]];

            if (left != -1 && right != -1 && left <= right) {
                result[i] = prefixSum[right] - prefixSum[left];
            } else {
                result[i] = 0;
            }
        }

        return result;
    }
}
