class Solution {
    public int numTeams(int[] nums) {
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            int mid=nums[i];
            int lefts=0;
            int leftl=0;
            int rights=0;
            int rightl=0;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    lefts++;
                }
                else{
                    leftl++;
                }
            }
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[i]){
                    rights++;
                }
                else{
                    rightl++;
                }
            }
            int sum=lefts*rightl+leftl*rights;
            cnt+=sum;

        }
        return cnt;
    }
}