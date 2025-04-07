class Solution {
    int sum=0;
    public void f(int ind,int []nums,List<Integer> list){
        if(ind>=nums.length){
            int xor=0;
           for(int i=0;i<list.size();i++){
             xor=xor^list.get(i);
           }
           sum+=xor;
           return;
        }
        //take
        list.add(nums[ind]);
        f(ind+1,nums,list);
        //nottake
        list.remove(list.size()-1);
        f(ind+1,nums,list);
    }
    public int subsetXORSum(int[] nums) {
        List<Integer> temp=new ArrayList<>();
        f(0,nums,temp);
        return sum;
    }
}