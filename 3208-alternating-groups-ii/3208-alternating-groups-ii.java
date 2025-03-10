class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        if (k == 0 || colors.length == 0) {
            return 0;
        }

        int cnt = 0;
        int alternatingCount = 1; // length of current alternating sequence
        int lastColor = colors[0];

        // First, linear traversal
        for (int j = 1; j < colors.length; j++) {
            if (colors[j] != lastColor) {
                alternatingCount++;
                if (alternatingCount >= k) {
                    cnt++;
                }
            } else {
                // Pattern breaks
                alternatingCount = 1;
            }
            lastColor = colors[j];
        }

        // Now, handle circular wrap-around for first k-1 elements
        for (int j = 0; j < k - 1; j++) {
            if (colors[j] != lastColor) {
                alternatingCount++;
                if (alternatingCount >= k) {
                    cnt++;
                }
            } else {
                break; // Pattern breaks, can't extend further
            }
            lastColor = colors[j];
        }

        return cnt;
    }
}
