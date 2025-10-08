class Solution {
    public int triangularSum(int[] nums) {
        int n = nums.length;
        long coeff = 1; // start with C(n-1,0)
        int result = 0;

        for (int i = 0; i < n; i++) {
            result = (int)((result + coeff * nums[i]) % 10);
            // compute next coefficient: C(n-1, i+1) = C(n-1, i) * (n-1-i) / (i+1)
            coeff = coeff * (n - 1 - i) / (i + 1);
        }

        return result;
    }
}
