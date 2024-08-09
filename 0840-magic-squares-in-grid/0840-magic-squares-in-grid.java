class Solution {
    public boolean helper(int [][]grid,int row,int col){
       int rows[]=new int[3];
       int cols[]=new int[3];
       int diagonal1=0;
       int diagonal2=0;
       //row sum;
       Set<Integer> s=new HashSet<>();
       for(int i=0;i<3;i++){
        for(int j=0;j<3;j++){
            int num=grid[row+i][col+j];
            if(num<1||num>9){
                return false;
            }
            if(!s.isEmpty()&&s.contains(num)){
                return false;
            }
            s.add(num);
            rows[i]+=num;
            cols[j]+=num;
            if(i==j){
                diagonal1+=num;
            }
            if(i+j==2){
                diagonal2+=num;
            }
        }
       }
       int sum=rows[0];
       for(int i=1;i<3;i++){
        if(rows[i]!=sum || cols[i]!=sum){
            return false;
        }
       }
       return sum==diagonal1 && sum==diagonal2;
       
    }
    public int numMagicSquaresInside(int[][] grid) {
        int ans=0;
        int n=grid.length;
        int m=grid[0].length;
        for(int row=0;row+2<n;row++){
            for(int col=0;col+2<m;col++){
                if(helper(grid,row,col)==true){
                    ans++;
                }
            }
        }
        return ans;
    }
}