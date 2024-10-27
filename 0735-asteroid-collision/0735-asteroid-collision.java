class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
       
        for(int i=0;i<asteroids.length;i++){
            if(st.isEmpty()||asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty() && st.peek()>0 && Math.abs(asteroids[i])>st.peek()){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0){
                    st.push(asteroids[i]);
                }
                else if(asteroids[i]+st.peek()==0){
                    st.pop();
                }
            }
        }
        int ans[]=new int[st.size()];
        for(int j=ans.length-1;j>=0;j--){
            ans[j]=st.pop();
        }
        return ans;
    }
}