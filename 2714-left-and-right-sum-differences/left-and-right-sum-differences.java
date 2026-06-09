class Solution {
    public int[] leftRightDifference(int[] nums) {
        int []leftSum=new int[nums.length];
        int []rightSum=new int[nums.length];
        int sum=nums[0];
        for(int i=1;i<nums.length;i++){
            leftSum[i]=sum;
            sum+=nums[i];
        }
        sum=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            rightSum[i]=sum;
            sum+=nums[i];
        }
        int ans[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            ans[i]=Math.abs(leftSum[i]-rightSum[i]);
        }
        return ans;
    }
}