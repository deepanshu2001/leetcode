class Solution {
    public boolean f(int ind,int nums[],int dp[]){
        if(ind>=nums.length-1){
            dp[ind]=0;
            return true;
        }
        if(dp[ind]!=-1){
            return dp[ind]==0?true:false;
        }
        for(int i=ind+1;i<=ind+nums[ind];i++){
            if(f(i,nums,dp)){
                dp[ind]=0;
                return true;
            }
        }
        dp[ind]=1;
        return false;

    }
    public boolean canJump(int[] nums) {
        int dp[]=new int[nums.length+1];
        Arrays.fill(dp,-1);
        return f(0,nums,dp);
    }
}