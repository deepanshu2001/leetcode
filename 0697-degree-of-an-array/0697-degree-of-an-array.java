class Solution {
    public int findShortestSubArray(int[] nums) {
        int degree = 0;

        // Step 1: find degree
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) {
            freq.put(x, freq.getOrDefault(x, 0) + 1);
            degree = Math.max(degree, freq.get(x));
        }

        // Step 2: sliding window to find smallest subarray with this degree
        Map<Integer, Integer> window = new HashMap<>();
        int i = 0, j = 0;
        int maxFreqInWindow = 0;
        int ans = Integer.MAX_VALUE;

        while (j < nums.length) {
            // expand window
            window.put(nums[j], window.getOrDefault(nums[j], 0) + 1);
            maxFreqInWindow = Math.max(maxFreqInWindow, window.get(nums[j]));

            // when window has the same degree
            while (maxFreqInWindow == degree) {
                ans = Math.min(ans, j - i + 1);

                // shrink from left
                window.put(nums[i], window.get(nums[i]) - 1);
                i++;

                // recompute max frequency in window (needed after shrinking)
                maxFreqInWindow = 0;
                for (int val : window.values()) {
                    maxFreqInWindow = Math.max(maxFreqInWindow, val);
                }
            }
            j++;
        }

        return ans;
    }
}
