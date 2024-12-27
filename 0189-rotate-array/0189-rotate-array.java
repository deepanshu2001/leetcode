class Solution {
    public void rotate(int[] nums, int k) {
        if(nums.length==k){
            return;
        }
        List<Integer> list=new ArrayList<>();
        int ind=nums.length-1;
        while(k>0 && ind>0){
            list.add(0,nums[ind]);
            ind--;
            k--;
        }
        for(int i=0;i<=ind;i++){
            list.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            nums[i]=list.get(i);
        }

    }
}