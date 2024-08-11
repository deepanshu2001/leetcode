class Solution {
    public void helper(int[] nums,int ind,List<Integer> curr,List<List<Integer>> ans){
        ans.add(new ArrayList<>(curr));
        for(int i=ind;i<nums.length;i++){
            if(ind!=i && nums[i]==nums[i-1]){
                continue;
            }
            //take
            curr.add(nums[i]);
            helper(nums,i+1,curr,ans);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        helper(nums,0,curr,ans);
        return ans;
    }
}