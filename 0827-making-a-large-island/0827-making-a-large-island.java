class DisjointSet {
    List<Integer> parent=new ArrayList<>();
    List<Integer> rank=new ArrayList<>();
    List<Integer> size=new ArrayList<>();
    public DisjointSet(int n){
        for(int i=0;i<=n;i++){
            parent.add(i);
            rank.add(0);
            size.add(1);
        }
    }
    public int findUPar(int node){
        if(node==parent.get(node)){
            return node;
        }
        int Upar=findUPar(parent.get(node));
        parent.set(node,Upar);
        return parent.get(node);

    }
    public void unionByRank(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(rank.get(up)<rank.get(vp)){
            parent.set(up,vp);
        }
        else if(rank.get(vp)<rank.get(up)){
            parent.set(vp,up);
        }
        else{
            parent.set(vp,up);
            int rankU=rank.get(up);
            rank.set(up,rankU+1);
        }
    }
    public void unionBySize(int u,int v){
        int up=findUPar(u);
        int vp=findUPar(v);
        if(up==vp){
            return;
        }
        if(size.get(up)<size.get(vp)){
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }
        else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}
class Solution {

    public int largestIsland(int[][] grid) {
        //part 1 connceting all 1's
        int n=grid.length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        DisjointSet ds=new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    continue;
                }
                for(int k=0;k<4;k++){
                    int nrow=deltarow[k]+i;
                    int ncol=deltacol[k]+j;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        int node=i*n+j;
                        int adjnode=nrow*n+ncol;
                        ds.unionBySize(node,adjnode);
                    }
                }
            }
        }
        //checking the island
        int max=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    continue;
                }
                Set<Integer> comp=new HashSet<>();
                for(int i=0;i<4;i++){
                    int nrow=deltarow[i]+row;
                    int ncol=deltacol[i]+col;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && grid[nrow][ncol]==1){
                        comp.add(ds.findUPar(nrow*n+ncol));
                    }
                }
                int total=0;
                for(Integer p:comp){
                   total+=ds.size.get(p);
                }
                max=Math.max(max,total+1);
            }
        }
        for(int cell=0;cell<n*n;cell++){
            max=Math.max(max,ds.size.get(ds.findUPar(cell)));
        }
        return max;
        
    }
}