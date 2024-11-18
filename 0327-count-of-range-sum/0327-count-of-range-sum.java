import java.util.Arrays;

class Solution {
    public int[] sort(int nums1[], int nums2[]) {
        int arr[] = new int[nums1.length + nums2.length];
        int k = 0;
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr[k] = nums1[i];
                i++;
            } else {
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while (i < nums1.length) {
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while (j < nums2.length) {
            arr[k] = nums2[j];
            j++;
            k++;
        }
        return arr;
    }

    public int[] merge(int nums[]) {
        if (nums.length == 1) {
            return nums;
        }
        int mid = nums.length / 2;
        int left[] = merge(Arrays.copyOfRange(nums, 0, mid));
        int right[] = merge(Arrays.copyOfRange(nums, mid, nums.length));
        return sort(left, right);
    }

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] prefixSums = new long[nums.length + 1];
        prefixSums[0] = 0; // Initial prefix sum
        
        // Calculate prefix sums
        for (int i = 0; i < nums.length; i++) {
            prefixSums[i + 1] = prefixSums[i] + nums[i];
        }

        // Count valid range sums using modified merge sort
        return countWithMergeSort(prefixSums, 0, prefixSums.length, lower, upper);
    }

    private int countWithMergeSort(long[] prefixSums, int left, int right, int lower, int upper) {
        if (right - left <= 1) {
            return 0;
        }

        int mid = (left + right) / 2;
        int count = countWithMergeSort(prefixSums, left, mid, lower, upper) +
                    countWithMergeSort(prefixSums, mid, right, lower, upper);

        // Count the number of valid subarray sums using binary search
        int j = mid, k = mid;
        for (int i = left; i < mid; i++) {
            while (k < right && prefixSums[k] - prefixSums[i] < lower) k++;
            while (j < right && prefixSums[j] - prefixSums[i] <= upper) j++;
            count += (j - k);
        }

        // Merge step: Custom merge logic using your `sort` method
        long[] leftArray = Arrays.copyOfRange(prefixSums, left, mid);
        long[] rightArray = Arrays.copyOfRange(prefixSums, mid, right);
        long[] mergedArray = mergeArrays(leftArray, rightArray);

        // Copy merged array back into the original prefix sums
        System.arraycopy(mergedArray, 0, prefixSums, left, mergedArray.length);

        return count;
    }

    private long[] mergeArrays(long[] left, long[] right) {
        int i = 0, j = 0, k = 0;
        long[] result = new long[left.length + right.length];
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }
        return result;
    }
}
