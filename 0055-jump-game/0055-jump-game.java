class Solution {
    boolean flag=false;
    public boolean f(int start,int nums[],int dp[]){
        if(start>=nums.length-1){
           dp[start]=1;
           return true;
        }
        if(dp[start]!=-1){
            return dp[start]==1?true:false;
        }
        for(int i=start+1;i<=start+nums[start];i++){
            if(f(i,nums,dp)){
                dp[start]=1;
                return true;
            }
        }
        dp[start]=0;
        return false;
    }
    public boolean canJump(int[] nums) {
        
        boolean dp[]=new boolean [nums.length+1];
        dp[nums.length-1]=true;
        for(int start=nums.length-2;start>=0;start--){
          for(int jump=start+1;jump<=start+nums[start];jump++){
            if(jump<=nums.length-1 && dp[jump]){
                dp[start]=true;
            }
          }
        }
        return dp[0];
    }
}