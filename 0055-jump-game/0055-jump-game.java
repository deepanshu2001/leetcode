class Solution {
    boolean flag=false;
    public boolean f(int start,int nums[]){
        if(start>=nums.length-1){
           return true;
        }
        for(int i=start+1;i<=start+nums[start];i++){
            if(f(i,nums)){
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        
        int dp[]=new int[nums.length];
        Arrays.fill(dp,-1);
        return f(0,nums);
        
    }
}