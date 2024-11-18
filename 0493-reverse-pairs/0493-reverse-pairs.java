class Solution {
    int cnt = 0;

    public void merge(int[] nums, int s, int mid, int e) {
        int j = mid + 1;
        for (int i = s; i <= mid; i++) {
            while (j <= e && (long) nums[i] > 2 * (long) nums[j]) {
                j++;
            }
            cnt += j - (mid + 1);
        }
        int[] mix = new int[e - s + 1];
        int index = 0;
        int i = s;
        j = mid + 1;

        while (i <= mid && j <= e) {
            if (nums[i] <= nums[j]) {
                mix[index++] = nums[i++];
            } else {
                mix[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            mix[index++] = nums[i++];
        }
        while (j <= e) {
            mix[index++] = nums[j++];
        }

        System.arraycopy(mix, 0, nums, s, mix.length);
    }

    public void mergeSort(int[] nums, int s, int e) {
        if (s >= e) {
            return;
        }
        int mid = s + (e - s) / 2;
        mergeSort(nums, s, mid);
        mergeSort(nums, mid + 1, e);
        merge(nums, s, mid, e);
    }

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return cnt;
    }
}
