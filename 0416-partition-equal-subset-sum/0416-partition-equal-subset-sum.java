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
        boolean dp[][]=new boolean[nums.length+1][target+1];
        for(int i=0;i<=nums.length;i++){
            dp[i][0]=true;
        }
        for(int i=nums.length-1;i>=0;i--){
            for(int tar=0;tar<=target;tar++){
                boolean nottake=dp[i+1][tar];
                boolean take=false;
                if(tar>=nums[i]){
                    take=dp[i+1][tar-nums[i]];
                }
                dp[i][tar]=take||nottake;
            }
        }
        return dp[0][target];
    }
}