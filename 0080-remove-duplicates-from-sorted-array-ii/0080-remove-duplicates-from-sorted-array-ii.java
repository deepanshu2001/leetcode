class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt=0;
        int n=nums.length;
        int i=0;
        while(i<nums.length-2){
            int j=i+2;
            if(nums[i]!=nums[j]){
                i=i+2;
            }
            else{
                cnt++;
                while(j<nums.length-1){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                    j++;
                }
            }
        }
        return n-cnt;
    }
}