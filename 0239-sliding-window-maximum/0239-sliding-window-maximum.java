class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q=new ArrayDeque<>();
        int ans[]=new int[nums.length-k+1];
        int ind=0;
        int i=0;
        int j=0;
        while(j<nums.length){
           while(q.size()>0 && q.peekLast()<nums[j]){
               q.removeLast();
           }
           q.add(nums[j]);
           if(j-i+1<k){
               j++;
           }
           else if(j-i+1==k){
               ans[ind++]=q.peek();
               if(q.peek()==nums[i]){
                   q.remove();
               }
               i++;
               j++;
           }
        }
        return ans;
    }
}