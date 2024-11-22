class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> set = new HashSet<>();
        for (String word : dictionary) {
            set.add(word);
        }
        int dp[] = new int[s.length()+1];
        
        int n=s.length();
        dp[n]=0;
        for(int i=s.length()-1;i>=0;i--){
            String curr_str = "";
            int min_extra = Integer.MAX_VALUE;
            for (int idx =i; idx < n; idx++) {
                curr_str += s.charAt(idx);
                int curr_extra = set.contains(curr_str) ? 0 : curr_str.length();
                int next_extra = dp[idx+1];
                min_extra = Math.min(min_extra, curr_extra + next_extra);
                
            }
            dp[i]=min_extra;

        }
        return dp[0];
    }
}
