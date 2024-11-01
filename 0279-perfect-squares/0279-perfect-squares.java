class Solution {
    public int f(int ind, List<Integer> list, int target,int dp[][]) {
        if (target == 0) {
            return dp[ind][target]=0;
        }
        if (ind == list.size() || target < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[ind][target]!=-1){
            return dp[ind][target];
        }
        int take = Integer.MAX_VALUE;
        if (list.get(ind) <= target) {
            int result = f(ind, list, target - list.get(ind),dp);
            if (result != Integer.MAX_VALUE) {
                take = 1 + result;
            }
        }
        int notTake = f(ind + 1, list, target,dp);
        return dp[ind][target]=Math.min(take, notTake);
    }

    public int numSquares(int n) {
        List<Integer> list = new ArrayList<>();
      
        for (int i = 1; i * i <=n; i++) {
            list.add(i * i);
        }
          int dp[][]=new int[list.size()+1][n+1];
          for(int row[]:dp){
            Arrays.fill(row,-1);
          }
        int result = f(0, list, n,dp);
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
