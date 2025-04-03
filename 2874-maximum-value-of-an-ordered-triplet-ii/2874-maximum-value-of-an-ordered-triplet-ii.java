class Solution {
    public long maximumTripletValue(int[] nums) {
        int leftMax[]=new int[nums.length];
        int rightMax[]=new int[nums.length];

        for(int i=1;i<nums.length;i++){
            leftMax[i]=Math.max(leftMax[i-1],nums[i-1]);
            rightMax[nums.length-i-1]=Math.max(nums[nums.length-i],rightMax[nums.length-i]);
        }
        long ans=0;
        for(int j=1;j<nums.length-1;j++){
            ans=Math.max(ans,(long)(leftMax[j]-nums[j])*rightMax[j]);
        }
        return ans;
    }
}