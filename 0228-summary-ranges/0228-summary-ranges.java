class Solution {
    public List<String> summaryRanges(int[] nums) {
       List<String> ans=new ArrayList<>();
       for(int i=0;i<nums.length;i++){
        int start=nums[i];
        while(i+1<nums.length && nums[i]==nums[i+1]-1){
            i++;
        }
        String s="";
        s+=start;
        if(nums[i]!=start){
            s+="->";
            s+=nums[i];
        }
        ans.add(s);
       }
       return ans;   
    }
}