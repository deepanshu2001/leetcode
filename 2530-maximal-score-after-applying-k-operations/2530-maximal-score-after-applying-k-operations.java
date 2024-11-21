class Solution {
    public long maxKelements(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int num:nums){
            pq.add(num);
        }
        int score=0;
        while(k>0){
            int num=pq.remove();
            score+=num;
            pq.add((int)Math.ceil(num*1.0/3));
            k--;
        }
        return score;
    }
}