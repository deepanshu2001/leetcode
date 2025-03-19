class Solution {
    public int minOperations(int[] nums) {
        int ans=0;
        int i=0;
        int j=0;
        int k=3;
        while(j<nums.length){
            if(j-i+1<k){
                j++;
                continue;
            }
            if(j-i+1==k){
                if(nums[i]==0){
                    for(int p=i;p<i+k && p<nums.length;p++){
                        nums[p]=nums[p]==1?0:1;
                    }
                    ans++;
                }
                i++;
            }
        }
        for(int num:nums){
            if(num==0){
                return -1;
            }
        }
        return ans;
    }
}