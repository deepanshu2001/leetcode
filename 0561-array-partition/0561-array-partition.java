class Solution {
    public int arrayPairSum(int[] nums) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
            min = Math.min(min, num);
        }

        int[] count = new int[max - min + 1];
        for (int num : nums) {
            count[num - min]++;
        }

        int index = 0;
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                nums[index++] = i + min; // convert back to original number
                count[i]--;
            }
        }

        int ans = 0;
        for (int i = 0; i < nums.length; i += 2) {
            ans += nums[i];
        }

        return ans;
    }
}
