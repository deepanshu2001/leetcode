class Solution {
    public int[] productExceptSelf(int[] nums) {
        //Brute
        int arr[]=new int[nums.length];
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=0;j<nums.length;j++){
               if(i!=j){
                prod=prod*nums[j];
               }
            }
            arr[i]=prod;
        }
        return arr;
    }
}