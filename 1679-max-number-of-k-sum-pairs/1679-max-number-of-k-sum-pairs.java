class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt=0;
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if(sum<k){
                i++;
            }
            else if(sum>k){
                j--;
            }
            else if(sum==k){
                cnt++;
                i++;
                j--;
            }
        }
        return cnt;
    }
}