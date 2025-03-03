class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> less=new ArrayList<>();
        List<Integer> equal=new ArrayList<>();
        List<Integer> greater=new ArrayList<>();
        for(int num:nums){
            if(num==pivot){
                equal.add(num);
            }
            else if(num<pivot){
                less.add(num);
            }
            else{
                greater.add(num);
            }
        }
        int ans[]=new int[nums.length];
        int ind=0;
        for(int num:less){
            ans[ind]=num;
            ind++;
        }
        for(int num:equal){
            ans[ind]=num;
            ind++;
        }
        for(int num:greater){
            ans[ind]=num;
            ind++;
        }
        return ans;
    }
}