class Solution {
    public boolean f(int ind,int nums[]){
        if(ind==nums.length-1){
            return true;
        }
        for(int i=ind+1;i<=ind+nums[ind];i++){
            if(f(i,nums)){
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return f(0,nums);
    }
}