class Solution {
    public boolean canArrange(int[] arr, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : arr) {
            int rem = num % k;
            if (rem < 0) {
                rem += k; // Adjust for negative remainders
            }
            map.put(rem, map.getOrDefault(rem, 0) + 1);
        }
        
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int rem = entry.getKey();
            int cnt = entry.getValue();
            
            if (rem == 0) {
                // Remainder 0 must have an even count
                if (cnt % 2 != 0) {
                    return false;
                }
            } else if (2 * rem == k) {
                // When k is even and rem == k/2
                // Count must be even
                if (cnt % 2 != 0) {
                    return false;
                }
            } else {
                int comp = k - rem;
                int compCnt = map.getOrDefault(comp, 0);
                if (cnt != compCnt) {
                    return false;
                }
            }
        }
        return true;
    }
}
