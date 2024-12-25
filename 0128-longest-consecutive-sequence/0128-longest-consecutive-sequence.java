class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans=0;
        for(int it:set){
            if(!set.contains(it-1)){
                int x=it;
                int cnt=1;
                while(set.contains(x+1)){
                    x=x+1;
                    cnt++;
                }
                ans=Math.max(ans,cnt);

            }
        }
        return ans;
    }
}