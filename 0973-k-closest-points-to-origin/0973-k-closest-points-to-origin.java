class Pair{
    double first;
    int second;
    int third;
    public Pair(double first,int second,int third){
        this.first=first;
        this.second=second;
        this.third=third;
    }
}
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        PriorityQueue<Pair> pq=new  PriorityQueue<>((x, y) -> Double.compare(y.first, x.first));
        for(int i=0;i<n;i++){
            int x=points[i][0];
            int y=points[i][1];
            double dist=Math.sqrt(x*x+y*y);
            pq.add(new Pair(dist,x,y));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int size=pq.size();
        int ans[][]=new int[size][2];
        int ind=0;
        while(pq.size()!=0){
            Pair pair=pq.remove();
            int xi=pair.second;
            int yi=pair.third;
            
            ans[ind][0]=xi;
            ans[ind][1]=yi;
            ind++;
        }
        return ans;
    }
}