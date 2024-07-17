class Solution {
    public int maximumCandies(int[] candies, long k) {
        long ss=0;
        for(int i=0;i<candies.length;i++){
            ss+=candies[i];
        }
        if(ss<k){
            return 0;
        }
        long s = 1; // Start from 1 instead of 0 to avoid division by zero
        long max = Long.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, (long)candies[i]);
        }
        long e = max;
        while (s <= e) {
            long mid = s + (e - s) / 2;
            long sum = 0;
            for (int i = 0; i < candies.length; i++) {
                sum += candies[i] / mid;
            }
            if (sum < k) {
                e = mid - 1;
            } else {
                s = mid + 1; // Update s to mid + 1
            }
        }
        return (int)e; // Return e instead of s to get the correct maximum
    }
}
