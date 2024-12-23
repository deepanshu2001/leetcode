class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        ans.add(new ArrayList<>());
        for(int num:nums){
            List<List<Integer>> new_subsets=new ArrayList<>();
            for(List<Integer> curr:ans){
                List<Integer> temp=new ArrayList<>(curr);
                temp.add(num);
                new_subsets.add(temp);
            }
            for(List<Integer> curr:new_subsets){
                ans.add(curr);
            }
        }
        return ans;
    }
}