class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int arr[]=new int[nums.length];
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                cnt++;
                arr[i]=cnt;
            }
            else{
                cnt=0;
                arr[i]=0;
            }
        }
        long ans=0;
        for(int i=0;i<nums.length;i++){
            ans+=arr[i];
        }
        return ans;
    }
}