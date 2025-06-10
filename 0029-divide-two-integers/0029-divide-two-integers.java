class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow edge case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine sign
        boolean sign = (dividend >= 0) == (divisor >= 0);

        // Work with positive long values
        long n = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        long quotient = 0;

        while (n >= d) {
            int cnt = 0;
            while (n >= (d << (cnt + 1))) {
                cnt++;
            }
            quotient += 1L << cnt;
            n -= d << cnt;
        }

        quotient = sign ? quotient : -quotient;

        // Clamp to int range
        if (quotient > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (quotient < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) quotient;
    }
}
