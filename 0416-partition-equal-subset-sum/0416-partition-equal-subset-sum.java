class Solution {
    public boolean f(int ind,int target,int []nums){
        //take 
        if(target==0){
            return true;
        }
        if(ind==nums.length){
            return false;
        }
        boolean take=false;
        if(target>=nums[ind]){
            take=f(ind+1,target-nums[ind],nums);
        }
        //nottake
        boolean nottake=f(ind+1,target,nums);
        return take||nottake;
    }
    public boolean canPartition(int[] nums) {
        int total_sum=0;
        for(int num:nums){
            total_sum+=num;
        }
        if(total_sum%2==1){
            return false;
        }
        int target=total_sum/2;
        return f(0,target,nums);
    }
}