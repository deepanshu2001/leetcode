class Solution {

    public int numberOfAlternatingGroups(int[] colors, int k) {
        if (k == 0 || colors.length == 0) {
            return 0;
        }
        int cnt = 0;
        int alternatingCount = 1; 
        int lastColor = colors[0];
        for (int j = 1; j < colors.length; j++) {
            if (colors[j] != lastColor) {
                alternatingCount++;
                if (alternatingCount >= k) {
                    cnt++;
                }
            } else {
                alternatingCount = 1;
            }
            lastColor = colors[j];
        }
        for (int j = 0; j < k - 1; j++) {
            if (colors[j] != lastColor) {
                alternatingCount++;
                if (alternatingCount >= k) {
                    cnt++;
                }
            } else {
                break;
            }
            lastColor = colors[j];
        }

        return cnt;
    }
}
