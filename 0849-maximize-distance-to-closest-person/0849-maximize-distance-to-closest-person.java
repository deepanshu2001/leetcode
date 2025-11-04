class Solution {
    public int maxDistToClosest(int[] seats) {
        int ans=0;
        int n=seats.length;
        int left[]=new int[n];
        int right[]=new int[n];
        for(int i=0;i<n;i++){
           int left_seat=-1;
           int right_seat=-1;
           for(int j=i;j>=0;j--){
            if(seats[j]==1){
                left_seat=j;
                break;
            }
           }
           left[i]=left_seat;
           for(int j=i;j<n;j++){
            if(seats[j]==1){
                right_seat=j;
                break;
            }
           }
           right[i]=right_seat;
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