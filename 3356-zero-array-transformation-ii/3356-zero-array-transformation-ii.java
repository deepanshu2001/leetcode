class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries,int k) {
        int diff[]=new int[nums.length+1];
        for(int i=0;i<k;i++){
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
    public int minZeroArray(int[] nums, int[][] queries) {
        int  n=nums.length;
        int left=0;
        int right=queries.length;
        if(!isZeroArray(nums, queries,right)){
            return -1;
        }
        while(left<=right){
            int mid=left+(right-left)/2;
            if(isZeroArray(nums, queries, mid)){
                right=mid-1;
            }
            else{
                left=mid+1;
            }
        }
        return left;
    }
}