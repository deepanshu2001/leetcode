class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans=new ArrayList<>();
        if(numRows==0){
            return ans;
        }
        List<Integer> temp=new ArrayList<>();
        temp.add(1);
        ans.add(new ArrayList<>(temp));
        if(numRows==1){
            return ans;
        }
        temp.add(1);
        ans.add(new ArrayList<>(temp));
        for(int i=2;i<numRows;i++){
            List<Integer> list=ans.get(i-1);
            List<Integer> new_list=new ArrayList<>();
            new_list.add(1);
            for(int j=0;j<list.size()-1;j++){
                new_list.add(list.get(j)+list.get(j+1));
            }
            new_list.add(1);
            ans.add(new ArrayList<>(new_list));

        }
        return ans;
    }
}