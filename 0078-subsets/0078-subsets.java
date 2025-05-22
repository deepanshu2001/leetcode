class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void f(int ind,int nums[],List<Integer> temp){
        if(ind==nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }
        //take
        temp.add(nums[ind]);
        f(ind+1,nums,temp);
        //not take;
        temp.remove(temp.size()-1);
        f(ind+1,nums,temp);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        f(0,nums,temp);
        return ans;
    }
}