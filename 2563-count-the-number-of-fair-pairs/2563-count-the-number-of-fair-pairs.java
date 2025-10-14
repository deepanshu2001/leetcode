class Solution {
    public int bs(int []nums,int s,int e,int target){
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]>=target){
                e=mid-1;
            }
            else{
                s=mid+1;
            }
        }
        return s;
    }
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans=0;
        for(int i=0;i<nums.length;i++){
            int lower_bound=bs(nums,i+1,nums.length-1,lower-nums[i]);
            int upper_bound=bs(nums,i+1,nums.length-1,upper-nums[i]+1);
            ans+=1*(upper_bound-lower_bound);
        }
        return ans;
    }
}