class Solution {
    public void dfs(int[][] heights,int row,int col,int [][]res,int height,int []deltarow,int []deltacol){
        int n=heights.length;
        int m=heights[0].length;
        if(row<0||row>=n||col<0||col>=m||res[row][col]==1||heights[row][col]<height){
            return;
        }
        res[row][col]=1;
        for(int i=0;i<4;i++){
            int nrow=row+deltarow[i];
            int ncol=col+deltacol[i];
            dfs(heights,nrow,ncol,res,heights[row][col],deltarow,deltacol);
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int deltarow[]={-1,0,1,0};
        int deltacol[]={0,1,0,-1};
        int pacific[][]=new int[n][m];
        int atlantic[][]=new int[n][m];
        List<List<Integer>> ans=new ArrayList<>();
        //checking first col and last col;
        for(int i=0;i<n;i++){
            dfs(heights,i,0,pacific,Integer.MIN_VALUE,deltarow,deltacol);
            dfs(heights,i,m-1,atlantic,Integer.MIN_VALUE,deltarow,deltacol);
        }
        //checking first and last row
        for(int j=0;j<m;j++){
            dfs(heights,0,j,pacific,Integer.MIN_VALUE,deltarow,deltacol);
            dfs(heights,n-1,j,atlantic,Integer.MIN_VALUE,deltarow,deltacol);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
    }
}