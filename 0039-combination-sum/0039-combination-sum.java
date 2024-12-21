class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void f(int []candidates,List<Integer> list,int ind,int target){
        if(ind>=candidates.length){
            return;
        }
        if(target==0){
            ans.add(new ArrayList<>(list));
        }
        if(target>=candidates[ind]){
            list.add(candidates[ind]);
            f(candidates,list,ind,target-candidates[ind]);
            list.remove(list.size()-1);
            f(candidates,list,ind+1,target);
        }
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList<>();
        f(candidates,temp,0,target);
        return ans;
    }
}