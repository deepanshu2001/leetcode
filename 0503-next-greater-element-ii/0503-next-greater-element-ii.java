class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int ans[]=new int[nums.length];
        Stack<Integer> st=new Stack<>();
        for(int i=2*nums.length-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]<=nums[i%nums.length]){
                st.pop();
            }
            if(st.isEmpty()){
                ans[i%nums.length]=-1;
            }
            else{
                ans[i%nums.length]=nums[st.peek()];
            }
            st.push(i%nums.length);
        }
        return ans;
    }
}