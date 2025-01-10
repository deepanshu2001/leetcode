class Solution {
    class Pair{
        int first;
        int second;
        int third;
        Pair(int first,int second,int third){
            this.first=first;
            this.second=second;
            this.third=third;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->y.first-x.first);
        int [][]ans=new int[k][2];
        for(int point[]:points){
            int row=point[0];
            int col=point[1];
            int dist=row*row+col*col;
            pq.add(new Pair(dist,row,col));
            if(pq.size()>k){
                pq.remove();
            }
        }
        int ind=0;
        while(!pq.isEmpty()){
            Pair p=pq.remove();
            int row=p.second;
            int col=p.third;
            ans[ind][0]=row;
            ans[ind][1]=col;
            ind++;
        }
        return ans;
    }
}