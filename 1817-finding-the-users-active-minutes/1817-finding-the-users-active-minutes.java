class Solution {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        Arrays.sort( logs, (n1,n2)-> {
            if( n1[0] == n2[0] )
                return n1[1]-n2[1];
        return n1[0]-n2[0];
        });
        int curr_user=logs[0][0];
        int curr_time=logs[0][1];
        int cnt=1;
        int ans[]=new int[k];
        for(int i=1;i<logs.length;i++){
            if(curr_user==logs[i][0]){
               if(curr_time!=logs[i][1]){
                cnt++;
                curr_time=logs[i][1];
               }
            }
            else{
                ans[cnt-1]++;
                cnt=1;
                curr_user=logs[i][0];
                curr_time=logs[i][1];
            }
        }
        
        ans[cnt-1]++;
        
        return ans;
       
    }
}