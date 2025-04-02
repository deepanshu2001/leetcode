class Solution {
    public long maximumTripletValue(int[] nums) {
        int leftmax[]=new int[nums.length];
        int rightmax[]=new int[nums.length];
        for(int i=1;i<nums.length;i++){
            leftmax[i]=Math.max(nums[i-1],leftmax[i-1]);
            rightmax[nums.length-i-1]=Math.max(nums[nums.length-i],rightmax[nums.length-i]);
        }
        long ans=0;
        for(int j=1;j<nums.length-1;j++){
            ans=Math.max(ans,(long)(leftmax[j]-nums[j])*rightmax[j]);
        }
        return ans;

    }
}