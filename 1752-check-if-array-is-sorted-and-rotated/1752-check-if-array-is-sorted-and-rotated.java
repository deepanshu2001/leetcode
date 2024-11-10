class Solution {
    public boolean check(int[] nums) {
        int rotationCount = 0;
        int n = nums.length;

        // Traverse the array to count the number of rotation points
        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next element (modulus for circular check)
            if (nums[i] > nums[(i + 1) % n]) {
                rotationCount++;
            }

            // If there is more than one rotation point, it's not a rotated sorted array
            if (rotationCount > 1) {
                return false;
            }
        }

        // If zero or one rotation point is found, it's a rotated sorted array
        return true;
    }
}