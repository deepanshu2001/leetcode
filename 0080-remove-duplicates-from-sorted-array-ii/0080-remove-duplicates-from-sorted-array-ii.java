class Solution {
    public int removeDuplicates(int[] nums) {
        int cnt=1;
        int k=0;
        int prev=nums[0];
        for(int j=1;j<nums.length;j++){
            if(nums[j]==prev){
                cnt++;
            }
            else{
                prev=nums[j];
                cnt=1;
            }
            if(cnt>2){
                k++;
                nums[j]=Integer.MAX_VALUE;
            }
        }
        Arrays.sort(nums);
        return nums.length-k;
    }
}