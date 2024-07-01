/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */
 
class Solution {
    public int peakIndexInMountainArray(MountainArray mountainArr) {
        int s = 0;
        int e = mountainArr.length() - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) > mountainArr.get(mid + 1)) {
                // You're in the decreasing part of the array.
                // This may be the answer, but look at the left side too.
                e = mid;
            } else {
                // You're in the increasing part of the array.
                s = mid + 1;
            }
        }
        // In the end, s == e and pointing to the peak element
        return s;
    }

    public int bs(MountainArray mountainArr, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public int bsd(MountainArray mountainArr, int target, int s, int e) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (mountainArr.get(mid) == target) {
                return mid;
            } else if (mountainArr.get(mid) > target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return -1;
    }

    public int findInMountainArray(int target, MountainArray mountainArr) {
        int peakIndex = peakIndexInMountainArray(mountainArr);
        int result = bs(mountainArr, target, 0, peakIndex);
        if (result != -1) {
            return result;
        }
        return bsd(mountainArr, target, peakIndex + 1, mountainArr.length() - 1);
    }
}
