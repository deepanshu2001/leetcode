class Solution {
    public boolean f(int ind,int target,int []nums,int dp[][]){
        //take 
        if(target==0){
            dp[ind][target]=0;
            return true;
        }
        if(ind==nums.length){
            dp[ind][target]=1;
            return false;
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target]==0?true:false;
        }
        boolean take=false;
        if(target>=nums[ind]){
            take=f(ind+1,target-nums[ind],nums,dp);
        }
        //nottake
        boolean nottake=f(ind+1,target,nums,dp);
        dp[ind][target]=take||nottake?0:1;
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
        int dp[][]=new int[nums.length+1][target+1];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        return f(0,target,nums,dp);
    }
}