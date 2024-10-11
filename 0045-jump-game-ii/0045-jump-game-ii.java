class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int i=0;
        int j=0;
        while(j<nums.length-1){
            int farthest=0;
            for(int ind=i;ind<=j;ind++){
                farthest=Math.max(farthest,nums[ind]+ind);
            }
            i=j+1;
            j=farthest;
            jumps++;
        }
        return jumps;
    }
}