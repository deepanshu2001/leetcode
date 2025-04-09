class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {
        List<List<Integer>> ans=new ArrayList<>();
        Set<Integer> set=new HashSet<>();
        for(int  num:nums){
            set.add(num);
        }
        int R=-1;
        for(int i=lower;i<=upper;i++){
            if(!set.contains(i) && R==-1){
                R=i;
            }
            else if(set.contains(i) && R!=-1){
                List<Integer> temp=new ArrayList<>();
                temp.add(R);
                temp.add(i-1);
                ans.add(new ArrayList<>(temp));
                R=-1;
            }
        }
        if(R!=-1){
            List<Integer> temp=new ArrayList<>();
                temp.add(R);
                temp.add(upper);
                ans.add(new ArrayList<>(temp));
        }
        return ans;
    }
}