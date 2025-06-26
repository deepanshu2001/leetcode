class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void f(int ind,int []nums,List<Integer> curr){
        ans.add(new ArrayList<>(curr));
        for(int i=ind;i<nums.length;i++){
            if(i!=ind && nums[i]==nums[i-1]){
                continue;
            }
            curr.add(nums[i]);
            f(i+1,nums,curr);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        
        if(nums.length==0){
            return ans;
        }
        Arrays.sort(nums);
        List<Integer> curr=new ArrayList<>();
        f(0,nums,curr);
        return ans;
    }
}