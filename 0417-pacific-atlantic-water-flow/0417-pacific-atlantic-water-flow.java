class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    int deltarow[]={-1,0,1,0};
    int deltacol[]={0,1,0,-1};
    public void dfs(int row,int col,int height,int arr[][],int [][]heights){
       int n=heights.length;
       int m=heights[0].length;
       if(row<0 || row>=n||col<0||col>=m||arr[row][col]==1||height>heights[row][col]){
        return;
       }
       arr[row][col]=1;
       for(int i=0;i<4;i++){
        int nrow=row+deltarow[i];
        int ncol=col+deltacol[i];
        dfs(nrow,ncol,heights[row][col],arr,heights);
       }

    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n=heights.length;
        int m=heights[0].length;
        int pacific[][]=new int[n][m];
        int atlantic[][]=new int[n][m];
        //checking first col and last col
        for(int i=0;i<n;i++){
            dfs(i,0,Integer.MIN_VALUE,pacific,heights);
            dfs(i,m-1,Integer.MIN_VALUE,atlantic,heights);
        }

        //checking first row and last row
        for(int i=0;i<m;i++){
            dfs(0,i,Integer.MIN_VALUE,pacific,heights);
            dfs(n-1,i,Integer.MIN_VALUE,atlantic,heights);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(pacific[i][j]==1 && atlantic[i][j]==1){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(new ArrayList<>(temp));
                }
            }
        }
        return ans;
    }
}