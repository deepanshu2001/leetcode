class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        int i=0;
        int j=costs.length-1;
        long ans=0;
        while(k>0){
            while(pq1.size()<candidates && i<=j ){
                pq1.add(costs[i++]);
            }
            while(pq2.size()<candidates && i<=j ){
                pq2.add(costs[j--]);
            }
            int elem1=pq1.size()>0?pq1.peek():Integer.MAX_VALUE;
            int elem2=pq2.size()>0?pq2.peek():Integer.MAX_VALUE;
            if(elem1<=elem2){
                ans+=pq1.remove();
            }
            else{
                ans+=pq2.remove();
            }
            k--;
        }
        return ans;
    }
}