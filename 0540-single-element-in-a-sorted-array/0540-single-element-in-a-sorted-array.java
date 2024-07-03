class Solution {
    public int singleNonDuplicate(int[] nums) {
        int s=0;
        int e=nums.length-1;
        if(nums.length==1){
            return nums[0];
        }
        if(nums[0]!=nums[1]){
            return nums[0];
        }
        if(nums[nums.length-1]!=nums[nums.length-2]){
            return nums[nums.length-1];
        }
        while(s<=e){
            int mid=s+(e-s)/2;
            if(nums[mid]!=nums[mid+1] && nums[mid]!=nums[mid-1]){
                return nums[mid];
            }
            if(nums[mid]==nums[mid-1]){
                if((mid-s+1)%2==1){
                    e=mid-2;
                }
                else{
                    s=mid+1;
                }
            }
            else if(nums[mid]==nums[mid+1]){
                if((e-mid+1)%2==1){
                    s=mid+2;
                }
                else{
                    e=mid-1;
                }
            }
        }
        return -1;
    }
}