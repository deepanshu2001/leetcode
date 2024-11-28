class Solution {
    Map<Integer,Integer> map=new HashMap<>();
    public boolean solve(int ind,int pj,int []stones,int dp[][]){
        if(ind==stones.length-1){
            return true;
        }
        if(dp[ind][pj]!=-1){
            return dp[ind][pj]==1;
        }
        boolean ans=false;
        for(int nextJump=pj-1;nextJump<=pj+1;nextJump++){
            if(nextJump>0 && map.containsKey(stones[ind]+nextJump)){
              ans=ans||solve(map.get(stones[ind]+nextJump),nextJump,stones,dp);
            }
        }
        dp[ind][pj]=ans?1:0;
        return ans;
    }
    public boolean canCross(int[] stones) {
        if(stones[1]!=1){
            return false;
        }
        int n=stones.length;
        int dp[][]=new int[n][n];
        for(int row[]:dp){
            Arrays.fill(row,-1);
        }
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        return solve(0,0,stones,dp);
    }
}