class Solution {
    public int removeDuplicates(int[] nums) {
        int i=1;
        int cnt=1;
        if(nums.length==0){
            return 0;
        }
        for(int j=1;j<nums.length;j++){
            if(nums[j]==nums[j-1]){
                cnt++;
            }
            else{
                cnt=1;
            }
            if(cnt<=2){
                nums[i]=nums[j];
                i++;
            }
        }
        return i;
    }
}