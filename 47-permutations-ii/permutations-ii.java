class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void findPermutations(int ind, int[] nums) {
        if (ind == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        HashSet<Integer> used = new HashSet<>();

        for (int i = ind; i < nums.length; i++) {
            if (used.contains(nums[i])) {
                continue;
            }
            used.add(nums[i]);

            swap(i, ind, nums);
            findPermutations(ind + 1, nums);
            swap(i, ind, nums);
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        findPermutations(0, nums);
        return ans;
    }
}