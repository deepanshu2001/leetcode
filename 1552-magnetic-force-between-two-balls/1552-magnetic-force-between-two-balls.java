class Solution {
    public boolean calc_balls(int []position,int mid,int m){
        int cnt=1;
        int prev=position[0];
        for(int i=1;i<position.length;i++){
           if(position[i]-prev>=mid){
            cnt++;
            prev=position[i];
           }
        }
        return cnt>=m;
    }
    public int maxDistance(int[] position, int m) {
        int s=1;
        Arrays.sort(position);
        int e=position[position.length-1]-position[0];
        int ans=0;
        while(s<=e){
            int mid=s+(e-s)/2;
            if(calc_balls(position,mid,m)){
                ans=mid;
                s=mid+1;
            }
            else{
                e=mid-1;
            }
        }
        return ans;
    }
}