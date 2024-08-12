class Solution {
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> curr,int freq[]){
        if(curr.size()==nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(freq[i]!=1){
                curr.add(nums[i]);
                freq[i]=1;
                helper(nums,ans,curr,freq);
                freq[i]=0;
                curr.remove(curr.size()-1);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> curr=new ArrayList<>();
        int freq[]=new int[nums.length];
        helper(nums,ans,curr,freq);
        return ans;
    }
}