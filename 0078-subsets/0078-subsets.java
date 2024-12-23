class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void f(int ind,List<Integer> cur,int nums[]){
        if(ind>=nums.length){
            ans.add(new ArrayList<>(cur));
            return;
        }
        cur.add(nums[ind]);
        f(ind+1,cur,nums);
        cur.remove(cur.size()-1);
        f(ind + 1, cur, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        f(0,temp,nums);
        return ans;
    }
}