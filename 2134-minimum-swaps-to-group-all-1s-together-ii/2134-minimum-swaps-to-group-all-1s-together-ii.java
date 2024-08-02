class Solution {
    public int minSwaps(int[] nums) {
        int l=0;
        int r=0;
        int n=nums.length;
        int window_size=0;
        for(int i=0;i<nums.length;i++){
           window_size+=nums[i];
        }
        int curr_ones=0;
        int max_ones=0;
        while(r<2*n){
            if(nums[r%n]==1){
                curr_ones+=1;
            }
             if(r-l+1>window_size){
                    curr_ones-=nums[l%n];
                    l++;
            }
            max_ones=Math.max(max_ones,curr_ones);
            r++;
        }
        return window_size-max_ones;
        
    }
}