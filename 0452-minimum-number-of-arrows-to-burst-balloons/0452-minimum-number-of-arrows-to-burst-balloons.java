class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
        int ans=1;
        int end=points[0][1];
        for(int i=1;i<points.length;i++){
            int s=points[i][0];
            int e=points[i][1];
            if(s<=end){
                end=Math.min(end,e);
            }
            else{
                ans++;
                end=points[i][1];
            }
        }
        return ans;

    }
}