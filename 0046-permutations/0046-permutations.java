class Solution {
    public void helper(int[] nums,List<List<Integer>> ans,int ind){
        if(ind==nums.length){
            List<Integer> curr=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                curr.add(nums[i]);
            }
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(nums,i,ind);
            helper(nums,ans,ind+1);
            swap(nums,i,ind);
        }
    }
    public void swap(int nums[],int i,int j){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,ans,0);
        return ans;
    }
}