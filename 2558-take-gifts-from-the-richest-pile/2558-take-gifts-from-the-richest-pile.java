class Solution {
    public long pickGifts(int[] gifts, int k) {
        long ans=0;
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int gift:gifts){
            pq.add(gift);
        }
        while(k>0){
            Integer num=pq.remove();
            num=(int)Math.floor(Math.sqrt(num));
            pq.add(num);
            k--;
        }
        while(!pq.isEmpty()){
            ans+=pq.remove();
        }
        return ans;
    }
}