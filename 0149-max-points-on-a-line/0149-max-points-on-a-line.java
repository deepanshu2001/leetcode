import java.util.*;

class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        if (n == 1) {
            return 1;
        }
        int result = 2;

        for (int i = 0; i < n; i++) {
            Map<String, Integer> slopeMap = new HashMap<>();
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    int dx = points[j][0] - points[i][0];
                    int dy = points[j][1] - points[i][1];
                    int gcd = gcd(dx, dy);
                    
                    dx /= gcd;
                    dy /= gcd;
                    String slope = dy + "/" + dx;
                    
                    slopeMap.put(slope, slopeMap.getOrDefault(slope, 0) + 1);
                }
            }
            result = Math.max(result, Collections.max(slopeMap.values()) + 1);
        }
        return result;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
