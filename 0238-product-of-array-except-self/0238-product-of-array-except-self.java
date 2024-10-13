class Solution {
    public int[] productExceptSelf(int[] nums) {
        int []prefix=new int[nums.length];
        int postfix[]=new int[nums.length];
        prefix[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            prefix[i]=nums[i]*prefix[i-1];
        }
        postfix[nums.length-1]=nums[nums.length-1];
        for(int i=nums.length-2;i>=0;i--){
            postfix[i]=nums[i]*postfix[i+1];
        }
        int output[]=new int[nums.length];
        output[0]=1*postfix[1];
        output[nums.length-1]=prefix[nums.length-2]*1;
        for(int i=1;i<nums.length-1;i++){
           output[i]=prefix[i-1]*postfix[i+1];
        }
        return output;
    }
}