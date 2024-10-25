import java.util.Arrays;
import static java.util.Collections.min;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Integer indices[] = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> nums[i] != nums[j] ? nums[i] - nums[j] : i - j);

        int min_ind = nums.length;
        int max = 0;
        for (int i : indices) {
            max = Math.max(max, i - min_ind);
            min_ind = Math.min(min_ind, i);
        }
        return max;
    }
}
