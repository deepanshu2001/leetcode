class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        List<int []> list=new ArrayList<>();
        for(int i=0;i<intervals.length;i++){
            int s2=intervals[i][0];
            int e2=intervals[i][1];
            if(list.size()==0|| s2>list.get(list.size()-1)[1]){
                list.add(new int[]{s2,e2});
            }
            else{
                list.get(list.size()-1)[1]=Math.max(intervals[i][1],list.get(list.size()-1)[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }
}