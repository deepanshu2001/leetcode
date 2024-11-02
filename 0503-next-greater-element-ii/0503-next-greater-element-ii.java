class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[]=new int[nums.length];
        int ind=0;
        for(int i=0;i<nums.length;i++){
            int max=-1;
            for(int j=1;j<nums.length;j++){
                if(nums[(i+j)%nums.length]>nums[i]){
                    max=nums[(i+j)%nums.length];
                    break;
                }
            }
            ans[i]=max;
        }
        return ans;
    }
}