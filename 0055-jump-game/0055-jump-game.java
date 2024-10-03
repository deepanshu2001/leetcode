class Solution {
    public boolean f(int ind,int nums[]){
        if(ind==nums.length-1){
            return true;
        }
        int postion=nums[ind]+ind;
        for(int k=ind+1;k<=postion;k++){
            if(f(k,nums)){
                return true;
            }
        }
        return false;
    }
    public boolean canJump(int[] nums) {
        return f(0,nums);
    }
}