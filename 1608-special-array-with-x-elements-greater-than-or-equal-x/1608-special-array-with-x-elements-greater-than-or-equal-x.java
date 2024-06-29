class Solution {
    public int specialArray(int[] nums) {
        //here binary search is applied becuase its a array
        int start=0;
        int end=nums.length;
        while(start<=end){
            int mid=start+(end-start)/2;
            int cnt=0;
            for(int i=0;i<nums.length;i++){
               if(nums[i]>=mid){
                   cnt++;
               }
            }
            if(cnt==mid){
                return cnt;
            }
            if(cnt>mid){
                start=start+1;
            }
            else{
                end=end-1;
            }
        }
        return -1;
    }
}