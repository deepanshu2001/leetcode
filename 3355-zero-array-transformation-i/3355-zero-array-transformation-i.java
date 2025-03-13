class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int diff[]=new int[nums.length+1];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            diff[l]=diff[l]-1;
            diff[r+1]=diff[r+1]+1;
        }
        int curr_dic=0;
        for(int i=0;i<nums.length;i++){
            curr_dic+=diff[i];
            if(nums[i]+curr_dic>0){
                return false;
            }
        }
        return true;
    }
}