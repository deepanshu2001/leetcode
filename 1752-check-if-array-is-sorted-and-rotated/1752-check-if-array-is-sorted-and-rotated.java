class Solution {
    public boolean check(int[] nums) {
        // Edge case: If the array is empty or has one element, it is always true
        if (nums.length <= 1) {
            return true;
        }

        // Make a copy of the original array and sort it
        int[] sortedArr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(sortedArr);

        // Find the index where the array might have been rotated
        int rotationPoint = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] > nums[i + 1]) {
                rotationPoint = i;
                break;
            }
        }

        // If no rotation point is found, the array is already sorted
        if (rotationPoint == -1) {
            return true;
        }

        // Create a new array that simulates the rotation
        int[] rotatedArr = new int[nums.length];
        int index = 0;

        // Copy elements from rotation point to the end
        for (int i = rotationPoint + 1; i < nums.length; i++) {
            rotatedArr[index++] = nums[i];
        }

        // Copy elements from the start up to the rotation point
        for (int i = 0; i <= rotationPoint; i++) {
            rotatedArr[index++] = nums[i];
        }

        // Check if the rotated array matches the sorted array
        return Arrays.equals(rotatedArr, sortedArr);
    }
}