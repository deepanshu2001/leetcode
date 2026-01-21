class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length;
        int prev[]=new int[n];
        int curr[]=new int[n];
        int ans=(int)1e9;
        for(int i=0;i<n;i++){
            prev[i]=matrix[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<n;j++){
                int bt=matrix[i][j]+prev[j];
                int ld=matrix[i][j];
                if(j-1>=0){
                    ld+=prev[j-1];
                }
                else{
                    ld+=(int)1e9;
                }
                int rd=matrix[i][j];
                if(j+1<n){
                    rd+=prev[j+1];
                }
                else{
                    rd+=(int)1e9;
                }
                curr[j]=Math.min(bt,Math.min(ld,rd));
            }
            prev=curr.clone();

        }
        for(int i=0;i<n;i++){
            ans=Math.min(ans,prev[i]);
        }
        return ans;
    }
}