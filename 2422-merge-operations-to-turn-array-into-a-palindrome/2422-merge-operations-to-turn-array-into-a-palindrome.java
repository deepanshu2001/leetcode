class Solution {
    public int minimumOperations(int[] nums) {
        int l = 0, r = nums.length-1;
        int opr = 0;
        int leftSum = nums[l], rightSum = nums[r];
        while(l < r) {
            if(leftSum == rightSum) {
                l++;
                r--;
                leftSum = nums[l];
                rightSum = nums[r];
            } else if(leftSum < rightSum) {
                opr++;
                l++;
                leftSum += nums[l];
            } else {
                opr++;
                r--;
                rightSum += nums[r];
            }
        }

        return opr;
    }
}