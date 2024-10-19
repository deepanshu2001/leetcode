class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i=0;
        int j=0;
        Deque<Integer> dq=new ArrayDeque<>();
        int ans[]=new int[nums.length-k+1];
        int ind=0;
        while(j<nums.length){
            while(dq.size()>0 && dq.peekLast()<nums[j]){
                dq.removeLast();
            }
            dq.add(nums[j]);
            if(j-i+1<k){
                j++;
            }
            else{
                ans[ind++]=dq.peek();
                if(nums[i]==dq.peek()){
                    dq.remove();
                }
                i++;
                j++;
            }
        }
        return ans;
    }
}