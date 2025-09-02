class Solution {
    
    class Pair{
        int first;
        int second;
        public Pair(int first,int second){
            this.first=first;
            this.second=second;
        }
    }
    
    Set<List<String>> set = new HashSet<>();
    
    public void bfs(int [][]grid, int vis[][], int i, int j, List<String> list){
        vis[i][j] = 1;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(i, j));
        int deltarow[] = {-1, 0, 1, 0};
        int deltacol[] = {0, 1, 0, -1};
        int n = grid.length;
        int m = grid[0].length;
        
        // Add the initial position (could be (0,0) or any reference point)
        list.add("0,0");
        
        while (!queue.isEmpty()) {
            Pair pair = queue.remove();
            int row = pair.first;
            int col = pair.second;
            
            // For each neighbor, calculate the relative position and add it
            for (int k = 0; k < 4; k++) {
                int nrow = row + deltarow[k];
                int ncol = col + deltacol[k];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                    queue.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = 1;
                    // Add relative position movement in string form
                    list.add((nrow - i) + "," + (ncol - j));
                }
            }
        }
    }
    
    public int numDistinctIslands(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    List<String> list = new ArrayList<>();
                    bfs(grid, vis, i, j, list);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
