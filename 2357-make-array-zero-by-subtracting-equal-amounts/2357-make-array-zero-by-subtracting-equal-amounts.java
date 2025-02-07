class Solution {
    public int minimumOperations(int[] nums) {
        int cnt=0;
        if(nums.length==1){
            return cnt;
        }
        while(true){
            int smallest=Integer.MAX_VALUE;
            boolean allZero=true;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    smallest=Math.min(smallest,nums[i]);
                    allZero=false;
                }
            }
            if(allZero==true){
                break;
            }
            cnt++;
            for(int i=0;i<nums.length;i++){
                if(nums[i]>0){
                    nums[i]=nums[i]-smallest;
                }
            }
           
        }
        return cnt;
    }
}