class Solution {
    public int removeElement(int[] nums, int val) {
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]!=val){
               i++;
            }
            else{
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j--;
            }
        }
        int ans=0;
        for(int m=0;m<nums.length;m++){
            if(nums[m]!=val){
                ans++;
            }
            else{
                break;
            }
        }
        return ans;
    }
}