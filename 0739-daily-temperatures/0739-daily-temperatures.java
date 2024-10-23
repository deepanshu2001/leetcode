class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int ans[]=new int[temperatures.length];
        int hottest=0;
        for(int i=temperatures.length-1;i>=0;i--){
            int curr_temp=temperatures[i];
            if(curr_temp>=hottest){
                hottest=curr_temp;
                continue;
            }
            int days=1;
            while(temperatures[i+days]<=curr_temp){
                days+=ans[i+days];
            }
            ans[i]=days;
        }
        return ans;
    }
}