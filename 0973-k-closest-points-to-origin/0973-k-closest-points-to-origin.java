class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points,(a,b)->{
            return squaredDistance(a)-squaredDistance(b);
        });
        int ans[][]=new int[k][2];
        for(int i=0;i<k;i++){
            ans[i][0]=points[i][0];
            ans[i][1]=points[i][1];
        }
        return ans;
    }
    public int squaredDistance(int arr[]){
      return arr[0]*arr[0]+arr[1]*arr[1];
    }
}