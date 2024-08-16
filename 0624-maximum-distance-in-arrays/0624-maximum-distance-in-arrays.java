class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int i=0;
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        int ans=Integer.MIN_VALUE;
        for(List<Integer> ls:arrays){
          if(i==0){
            max=Math.max(max,ls.get(ls.size()-1));
            min=Math.min(min,ls.get(0));
          }
          else{
            int curr_min=ls.get(0);
            int curr_max=ls.get(ls.size()-1);
            int n1=Math.abs(max-curr_min);
            ans=Math.max(ans,n1);
            int n2=Math.abs(curr_max-min);
            ans=Math.max(ans,n2);
            max=Math.max(max,curr_max);
            min=Math.min(min,curr_min);
          }
          i++;
        }
        return ans;
    }
}