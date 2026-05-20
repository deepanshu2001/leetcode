class Solution {
    public int maxRotateFunction(int[] nums) {
        int n=nums.length;
        int sum=0;
        int F=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            F+=i*nums[i];
        }
        int result=F;
        for(int k=0;k<=n-1;k++){
            int newF=F+sum-n*nums[n-1-k];
            result=Math.max(result,newF);
            F=newF;
        }
        return result;
    }
}