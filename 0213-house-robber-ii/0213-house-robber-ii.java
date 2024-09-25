class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        List<Integer> l1=new ArrayList<>();
        List<Integer> l2=new ArrayList<>();
        if(nums.length==1){
            return nums[0];
        }
        int dp1[]=new int[n-1];
        int dp2[]=new int[n-1];
        Arrays.fill(dp1,-1);
        Arrays.fill(dp2,-1);
        dp1[0]=nums[0];
        dp2[0]=nums[0];
        
        for(int i=0;i<n-1;i++){
            l1.add(nums[i]);
        }
        for(int i=1;i<n;i++){
            l2.add(nums[i]);
        }
        int size=l1.size();
        for(int i=1;i<size;i++){
            int pick=l1.get(i);
            if(i>1){
                pick+=dp1[i-2];
            }
            int notpick=0+dp1[i-1];
            dp1[i]=Math.max(pick,notpick);
        }
         for(int i=1;i<size;i++){
            int pick=l2.get(i);
            if(i>1){
                pick+=dp2[i-2];
            }
            int notpick=0+dp2[i-1];
            dp2[i]=Math.max(pick,notpick);
        }
        return Math.max(dp1[size-1],dp2[size-1]);
    }
}