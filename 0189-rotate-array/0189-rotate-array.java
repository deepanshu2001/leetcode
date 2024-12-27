class Solution {
    public void rotate(int[] nums, int k) {
        if(k==0){
            return;
        }
        k=k%nums.length;
        reverse(0,nums.length-1,nums);
        reverse(0,k-1,nums);
        reverse(k,nums.length-1,nums);
    }
    public void reverse(int s,int e,int nums[]){
        while(s<e){
            int temp=nums[s];
            nums[s]=nums[e];
            nums[e]=temp;
            s++;
            e--;
        }
    }
}