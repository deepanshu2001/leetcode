class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int start=intervals[i][0];
            int end=intervals[i][1];
            if(!list.isEmpty() && list.get(list.size()-1).get(1)>=end){
                continue;
            }
            for(int j=i+1;j<intervals.length;j++){
                if(intervals[j][0]<=end){
                    end=Math.max(end,intervals[j][1]);
                }
                else{
                    break;
                }
            }
            List<Integer> temp=new ArrayList<>();
            temp.add(start);
            temp.add(end);
            list.add(new ArrayList<>(temp));
        }
        int ans[][]=new int[list.size()][2];
        int index=0;
        for(List<Integer> temp:list){
            int x=temp.get(0);
            int y=temp.get(1);
            ans[index][0]=x;
            ans[index][1]=y;
            index++;
        }
        return ans;
    }
}