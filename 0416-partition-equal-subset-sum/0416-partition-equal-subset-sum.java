class Solution {
    public boolean f(int ind,int target,int nums[],Boolean dp[][]){
        if(target==0){
            return true;
        }
        if(ind>=nums.length){
            return false;
        }
        if(dp[ind][target]!=null){
            return dp[ind][target];
        }
        boolean nottake=f(ind+1,target,nums,dp);
        boolean take=false;
        if(target>=nums[ind]){
            take=f(ind+1,target-nums[ind],nums,dp);
        }
        return dp[ind][target]=take||nottake;
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
        Boolean dp[][]=new Boolean[nums.length][target+1];
        
        return f(0,target,nums,dp);
    }
}