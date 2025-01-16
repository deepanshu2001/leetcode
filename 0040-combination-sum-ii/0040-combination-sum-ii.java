class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void f(int ind,int []candidates,int target,List<Integer> temp){
       if(target==0){
        ans.add(new ArrayList<>(temp));
        return;
       }
       for(int i=ind;i<candidates.length;i++){
         if(i>ind && candidates[i]==candidates[i-1]){
            continue;
         }
         if(candidates[i]>target){
            break;
         }
         temp.add(candidates[i]);
         f(i+1,candidates,target-candidates[i],temp);
         temp.remove(temp.size()-1);
       }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp=new ArrayList<>();
        f(0,candidates,target,temp);
        return ans;
    }
}