class Solution {
    public int countDays(int days, int[][] meetings) {
        int ans=0;
        PriorityQueue<int []> pq=new PriorityQueue<>((int a[],int b[])->a[0]-b[0]);
        for(int i=0;i<meetings.length;i++){
            pq.add(new int[]{meetings[i][0],meetings[i][1]});
        }
        int arr[]=pq.remove();
        int s1=arr[0];
        int e1=arr[1];
        while (!pq.isEmpty()) {
            int next[]=pq.remove();
            int s2=next[0];
            int e2=next[1];
            if(s2<=e1+1){
                e1=Math.max(e1,e2);
            }
            else{
                ans+=e1-s1+1;
                s1=s2;
                e1=e2;
            }
        }
        ans+=e1-s1+1;
        return days-ans;
    }
}