class Solution {
    public List<Integer> findPrimes(int m) {
        boolean[] primes = new boolean[20000];
        Arrays.fill(primes, true);
        primes[0] = primes[1] = false;

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i * i; j < primes.length; j += i) {
                    primes[j] = false;
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        for (int i = 2; ans.size() < m && i < primes.length; i++) {
            if (primes[i]) {
                ans.add(i);
            }
        }
        return ans;
    }

    public int f(List<Integer> primes, int ind, int sum, Integer[][] dp) {
        if (sum == 0) return 0; // Base case: 0 primes needed to make sum 0
        if (ind >= primes.size() || sum < 0) return Integer.MAX_VALUE; // Impossible case
        if (dp[ind][sum] != null) return dp[ind][sum];

        // Don't take current prime
        int notTake = f(primes, ind + 1, sum, dp);
        
        // Take current prime (can use multiple times)
        int take = f(primes, ind, sum - primes.get(ind), dp);
        if (take != Integer.MAX_VALUE) {
            take = 1 + take; // Add 1 for using this prime
        }

        return dp[ind][sum] = Math.min(take, notTake);
    }

    public int minNumberOfPrimes(int n, int m) {
        List<Integer> primes = findPrimes(m);
        Integer[][] dp = new Integer[m + 1][n + 1];
        int result = f(primes, 0, n, dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}