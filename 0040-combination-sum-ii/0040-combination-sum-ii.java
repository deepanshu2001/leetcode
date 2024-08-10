class Solution {
     public void getresult(int[] candidates,int target,List<List<Integer>> ans,List<Integer> res,int start){
        if(target==0){
            ans.add(new ArrayList<>(res));
            return;
        }
        else{
            for(int i=start;i<candidates.length;i++){
                if (i > start && candidates[i - 1] == candidates[i]) {
                   continue;
                }
                if (candidates[i] > target) {
                   break;
                }
               res.add(candidates[i]);
               getresult(candidates,target-candidates[i],ans,res,i+1);
               res.remove(res.size()-1);
            }
            
        }
          
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> res=new ArrayList<>();
        getresult(candidates,target,ans,res,0);
        return ans;
    }
}