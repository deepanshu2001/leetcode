class Solution {
    public int arrayPairSum(int[] nums) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        int ans=0;
        while(!pq.isEmpty()){
            pq.remove();
            ans+=pq.remove();
        }
        return ans;
    }
}