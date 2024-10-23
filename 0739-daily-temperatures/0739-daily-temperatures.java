class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st=new Stack<>();
        int ans[]=new int[temperatures.length];
        int ind=temperatures.length-1;
        for(int i=temperatures.length-1;i>=0;i--){
          while(!st.isEmpty() && temperatures[i]>=temperatures[st.peek()]){
            st.pop();
          }
          if(st.isEmpty()){
            ans[ind]=0;
            ind--;
          }
          else{
            ans[ind--]=st.peek()-i;
          }
          st.push(i);
        }
        return ans;
    }
}