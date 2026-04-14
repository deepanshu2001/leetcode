class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public void swap(int i,int j,int nums[]){
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    public void f(int ind,int nums[]){
        if(ind==nums.length){
            List<Integer> temp=new ArrayList<>();
            for(int i=0;i<nums.length;i++){
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            swap(i,ind,nums);
            f(ind+1,nums);
            swap(i,ind,nums);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        
        if(nums.length==0){
            return ans;
        }
        f(0,nums);
        return ans;
    }
}