class Solution {
     List<List<Integer>> ans=new ArrayList<>();
     public void f(int ind,int candidates[],int target,List<Integer> temp){
        //take
        if(ind==candidates.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(candidates[ind]<=target){
           temp.add(candidates[ind]);
           f(ind,candidates,target-candidates[ind],temp);
           temp.remove(temp.size()-1);
        }
        //nott ake
        f(ind+1,candidates,target,temp);
     }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
       
        List<Integer> temp=new ArrayList<>();
        f(0,candidates,target,temp);
        return ans;
    }
}