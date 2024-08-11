class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void helper(int num,int k,int n,List<Integer> curr){
        if(curr.size()>k){
            return;
        }
        if(n==0 && curr.size()==k){
            ans.add(new ArrayList<>(curr));
        }
        for(int i=num;i<=9;i++){
            curr.add(i);
            helper(i+1,k,n-i,curr);
            curr.remove(curr.size()-1);
            
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<Integer> curr=new ArrayList<>();
        helper(1,k,n,curr);
        return ans;
    }
}