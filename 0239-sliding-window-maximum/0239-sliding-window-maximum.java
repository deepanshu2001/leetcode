class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq=new ArrayDeque<>();
        int i=0;
        int j=0;
        int ans[]=new int[nums.length-k+1];
        int ind=0;
        while(j<nums.length){
            while(!dq.isEmpty() && nums[j]>dq.peekLast()){
                dq.removeLast();
            }
            dq.add(nums[j]);
            if(j-i+1==k){
               ans[ind++]=dq.peekFirst();
               if(nums[i]==dq.peekFirst()){
                dq.removeFirst();
               }
               i++;
            }
            j++;
        }
        return ans;
    }
}