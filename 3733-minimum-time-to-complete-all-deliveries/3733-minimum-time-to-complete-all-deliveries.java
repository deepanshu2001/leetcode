class Solution {
    public long minimumTime(int[] d, int[] r) {
        long l = 0, h = (long) 1e18;

        while (l < h) {
            long mid = (l + h) / 2;
            if (check(mid, d, r)) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(long t, int[] d, int[] r) {
        long a = t - t / r[0];
        long b = t - t / r[1];
        long lcm = (long) r[0] * r[1] / gcd(r[0], r[1]);
        long total = t - t / lcm;
        return a >= d[0] && b >= d[1] && (long) (d[0] + d[1]) <= total;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}