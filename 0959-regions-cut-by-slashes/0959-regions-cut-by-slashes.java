class Solution {
    public void dfs(int [][]arr,int i,int j){
        if(i<0||i>=arr.length||j<0||j>=arr.length||arr[i][j]==1){
            return;
        }
        arr[i][j]=1;
        dfs(arr,i-1,j);
        dfs(arr,i,j+1);
        dfs(arr,i+1,j);
        dfs(arr,i,j-1);
    }
    public int regionsBySlashes(String[] grid) {
        int n=grid.length;
        
        int arr[][]=new int[n*3][n*3];
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[i].toCharArray().length;j++){
               if(grid[i].charAt(j)=='/'){
                 arr[i*3][j*3+2]=1;
                 arr[i*3+1][j*3+1]=1;
                 arr[i*3+2][j*3]=1;
               }
               else if(grid[i].charAt(j)=='\\'){
                arr[i*3][j*3]=1;
                arr[i*3+1][j*3+1]=1;
                arr[i*3+2][j*3+2]=1;
               }
            }
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    dfs(arr,i,j);
                    ans++;
                }
            }
        }
        return ans;
    }
}