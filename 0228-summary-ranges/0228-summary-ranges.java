class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> ans=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int start=nums[i];
            while(i+1<nums.length && nums[i+1]==nums[i]+1){
                i++;
            }
            if(start!=nums[i]){
                String s=start+"->"+nums[i];
                ans.add(s);
            }
            else{
                ans.add(Integer.toString(nums[i]));
            }
        }
        return ans;
    }
}