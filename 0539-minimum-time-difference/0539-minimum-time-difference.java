class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean minutes[]=new boolean[24*60];
        for(int i=0;i<timePoints.size();i++){
            int h=Integer.parseInt(timePoints.get(i).substring(0,2));
            int m=Integer.parseInt(timePoints.get(i).substring(3));
            int min=h*60+m;
            if(minutes[min]==true){
                return 0;
            }
            minutes[min]=true;
        }
        int ans=Integer.MAX_VALUE;
        int prev_ind=Integer.MAX_VALUE;
        int last_Index=Integer.MAX_VALUE;
        int first_ind=Integer.MAX_VALUE;
        for(int i=0;i<24*60;i++){
            if(minutes[i]){
                if(prev_ind!=Integer.MAX_VALUE){
                    ans=Math.min(ans,i-prev_ind);
                }
                prev_ind=i;
                if(first_ind==Integer.MAX_VALUE){
                    first_ind=i;
                }
                last_Index=i;
            }
        }
        return Math.min(ans,24*60-last_Index+first_ind);
    }
}