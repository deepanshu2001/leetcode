class Solution {
    public boolean f(int ind,int nums[],int dp[]){
        if(ind==nums.length-1){
            dp[ind]=0;
            return true;
        }
        if(dp[ind]!=-1){
            return dp[ind]==0?true:false;
        }
        for(int i=ind+1;i<=ind+nums[ind];i++){
            if(f(i,nums,dp)){
                dp[i]=0;
                return true;
            }
        }
        dp[ind]=1;
        return false;
    }
    public boolean canJump(int[] nums) {
        boolean dp[]=new boolean[nums.length+nums.length];
        int n=nums.length;
        dp[n-1]=true;
        for(int ind=n-2;ind>=0;ind--){
           for(int i=ind+1;i<=ind+nums[ind];i++){
            if(dp[i]==true){
                dp[ind]=true;
            }
           }
        }
        return dp[0];
    }
}