class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                list.add(grid[i][j]);
            }
        }
        Collections.sort(list);
       int ans=0;
       int median=list.get(list.size()/2);
       for(int num:list){
          if(num%x!=median%x){
            return -1;
          }
          ans+=Math.abs(num-median)/x;
       }
       return ans;
    }
}