class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void helper(int ind,int target,List<Integer> curr,int[] candidates){
        if(target==0){
            ans.add(new ArrayList<>(curr));
        }
        for(int i=ind;i<candidates.length;i++){
            if(i>ind && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            curr.add(candidates[i]);
            helper(i+1,target-candidates[i],curr,candidates);
            curr.remove(curr.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> curr=new ArrayList<>();
        helper(0,target,curr,candidates);
        return ans;
    }
}