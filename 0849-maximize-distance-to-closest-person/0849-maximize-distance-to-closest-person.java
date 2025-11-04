class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans=0;
        int n=seats.length;
        int left[]=new int[n];
        int right[]=new int[n];
        int nearest_left=-1;
        int nearest_right=-1;
        for(int i=0;i<n;i++){
          if(seats[i]==1){
            nearest_left=i;
          }
          left[i]=nearest_left;
        }
        for(int i=n-1;i>=0;i--){
            if(seats[i]==1){
              nearest_right=i;
            }
            right[i]=nearest_right;
        }
        for(int i=0;i<n;i++){
            if(seats[i]==1 ||(left[i]== -1 && right[i]== -1)){
                continue;
            }
            else if(left[i]==-1){
                ans=Math.max(ans,Math.abs(i-right[i]));
            }
            else if(right[i]==-1){
                ans=Math.max(ans,Math.abs(i-left[i]));
            }
            else{
                if(Math.abs(i-left[i])<Math.abs(i-right[i])){
                    ans=Math.max(ans,i-left[i]);
                }
                else{
                    ans=Math.max(ans,right[i]-i);
                }
                
            }

        }
        return ans;
    }
}