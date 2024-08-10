class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void helper(int ind,int target,List<Integer> curr,int []candidates){
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(curr));
            }
            return;
        }
        //take
        if(candidates[ind]<=target){
            curr.add(candidates[ind]);
            //since there can be multiple take/not take call;
            helper(ind,target-candidates[ind],curr,candidates);
            curr.remove(curr.size()-1);
        }
        //not take;
        
        helper(ind+1,target,curr,candidates);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //since talking about about comibnations,we can use recursion and take/not take method (subset method);
        List<Integer> curr=new ArrayList<>();
        helper(0,target,curr,candidates);
        return ans;
    }
}