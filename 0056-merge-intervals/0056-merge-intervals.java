class Solution {
    public int[][] merge(int[][] intervals) {
        List<int []> list=new ArrayList<>();
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int start=intervals[0][0];
        int end=intervals[0][1];
        for(int arr[]:intervals){
            if(arr[0]<=end){
                end=Math.max(end,arr[1]);
            }
            else{
                list.add(new int[]{start,end});
                start=arr[0];
                end=arr[1];

            }
        }
        list.add(new int[]{start,end});
        int ind=0;
        int ans[][]=new int[list.size()][2];
        for(int arr[]:list){
            ans[ind][0]=arr[0];
            ans[ind][1]=arr[1];
            ind++;
        }
        return ans;
    }
}