class Solution {
    public int findLHS(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int cnt=0;
            boolean flag=false;
            for(int j=0;j<nums.length;j++){
                if(nums[i]==nums[j]){
                    cnt++;
                }
                else if(nums[i]+1==nums[j]){
                    cnt++;
                    flag=true;
                }
            }
            if(flag==true){
                ans=Math.max(ans,cnt);
            }
        }
        return ans;
    }
}