class Solution {
    Set<Integer> set=new HashSet<>();
    public int f(int curr_day,int []days,int []costs,int []dp){
        if(curr_day>days[days.length-1]){
            return 0;
        }
        if(dp[curr_day]!=-1){
            return dp[curr_day];
        }
        if(!set.contains(curr_day)){
            return f(curr_day+1,days,costs,dp);
        }
        int one_pass=costs[0]+f(curr_day+1,days,costs,dp);
        int seven_pass=costs[1]+f(curr_day+7,days,costs,dp);
        int thirty_pass=costs[2]+f(curr_day+30,days,costs,dp);
        return dp[curr_day]=Math.min(one_pass,Math.min(seven_pass,thirty_pass));
    }
    public int mincostTickets(int[] days, int[] costs) {
        for(int day:days){
            set.add(day);
        }
        int max_day=days[days.length-1];
        int dp[]=new int[max_day+1];
        Arrays.fill(dp,-1);
        return f(1,days,costs,dp);
    }
}