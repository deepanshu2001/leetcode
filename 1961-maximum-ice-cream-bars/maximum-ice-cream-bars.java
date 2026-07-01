class Solution {
    public int maxIceCream(int[] costs, int coins) {
        int n = 0;

        for (int cost : costs) {
            n = Math.max(n, cost);
        }

        int[] arr = new int[n + 1];

        for (int cost : costs) {
            arr[cost]++;
        }

        int ans = 0;

        for (int i = 1; i <= n; i++) {
            if (arr[i] == 0) continue;

            int canBuy = Math.min(arr[i], coins / i);
            ans += canBuy;
            coins -= canBuy * i;
        }

        return ans;
    }
}