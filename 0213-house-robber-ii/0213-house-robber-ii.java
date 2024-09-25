class Solution {
    public int f(int ind,List<Integer> l,int dp[]){
        if(ind==0){
            return l.get(0);
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int pick=l.get(ind)+f(ind-2,l,dp);
        int notpick=0+f(ind-1,l,dp);
        return dp[ind]=Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        int dp1[]=new int[n-1];
        int dp2[]=new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<n-1;i++){
            l1.add(nums[i]);
        }
        for(int i=1;i<n;i++){
            l2.add(nums[i]);
        }
        int size=l1.size();
        return Math.max(f(size-1,l1,dp1),f(size-1,l2,dp2));
    }
}