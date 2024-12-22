class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int i=0;
        int j=0;
        int farthest=0;
        while(i<nums.length-1){
           for(int ind=i;ind<=j;ind++){
            farthest=Math.max(farthest,nums[ind]+ind);
           }
           i=farthest;
           j=i+1;
           jumps++;
        }
        return jumps;
    }
}