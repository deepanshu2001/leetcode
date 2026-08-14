class Solution {
    public int f(int ind,List<Integer> list,int dp[]){
        if(ind==0){
            return list.get(ind);
        }
        if(ind<0){
            return 0;
        }
        if(dp[ind]!=-1){
            return dp[ind];
        }
        int nottake=f(ind-1,list,dp);
        int take=list.get(ind)+f(ind-2,list,dp);
        return dp[ind]=Math.max(take,nottake);
    }
    public int rob(int[] nums) {
        List<Integer> list1=new ArrayList<>();
        if(nums.length==1){
            return nums[0];
        }
        for(int i=0;i<nums.length-1;i++){
            list1.add(nums[i]);
        }
        List<Integer> list2=new ArrayList<>();
        for(int i=1;i<nums.length;i++){
            list2.add(nums[i]);
        }
        int dp1[]=new int[list1.size()+1];
        int dp2[]=new int[list2.size()+1];
        Arrays.fill(dp1,-1);
         Arrays.fill(dp2,-1);
        return Math.max(f(list1.size()-1,list1,dp1),f(list2.size()-1,list2,dp2));

    }
}