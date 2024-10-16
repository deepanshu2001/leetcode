class Solution {
    public void rotate(int[] nums, int k) {
        for(int i=0;i<k;i++){
            int val=nums[0];
            nums[0]=nums[nums.length-1];
            for(int j=1;j<nums.length;j++){
                int temp=nums[j];
                nums[j]=val;
                val=temp;
            }
        }
    }
}