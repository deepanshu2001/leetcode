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
        boolean dp[][]=new boolean[2001][2001];
        
        for(int i=0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        dp[0][0]=true;
        for(int ind=0;ind<n;ind++){
            for (int prevJump = 0; prevJump <= n; prevJump++) {
                // If stone exists, mark the value with position and jump as 1.
                if (dp[ind][prevJump]) {
                    if (map.containsKey(stones[ind] + prevJump)) {
                        dp[map.get(stones[ind] + prevJump)][prevJump] = true;
                    }
                    if (map.containsKey(stones[ind] + prevJump + 1)) {
                        dp[map.get(stones[ind] + prevJump + 1)][prevJump + 1] = true;
                    }
                    if (map.containsKey(stones[ind] + prevJump - 1)) {
                        dp[map.get(stones[ind] + prevJump - 1)][prevJump - 1] = true;
                    }
                }


            }
        }
        for (int index = 0; index <= n; index++) {
            if (dp[n - 1][index]) {
                return true;
            }
        }
        return false;
    }
}