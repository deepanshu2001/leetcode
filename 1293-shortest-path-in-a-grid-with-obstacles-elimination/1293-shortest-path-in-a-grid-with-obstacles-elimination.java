class Solution {
    class State {
        int row, col, steps, remainingK;
        public State(int row, int col, int steps, int remainingK) {
            this.row = row;
            this.col = col;
            this.steps = steps;
            this.remainingK = remainingK;
        }
    }
    
    public int shortestPath(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        
        if (n == 1 && m == 1) return 0; 
        boolean[][][] vis = new boolean[n][m][k + 1];
        
        Queue<State> q = new LinkedList<>();
        q.add(new State(0, 0, 0, k));
        vis[0][0][k] = true;
        
        int[] deltarow = {-1, 0, 1, 0};
        int[] deltacol = {0, 1, 0, -1};
        
        while (!q.isEmpty()) {
            State curr = q.poll();
            int row = curr.row, col = curr.col, steps = curr.steps, remainingK = curr.remainingK;
            if (row == n - 1 && col == m - 1) {
                return steps;
            }
            for (int i = 0; i < 4; i++) {
                int nrow = row + deltarow[i];
                int ncol = col + deltacol[i];
                
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newK = remainingK - grid[nrow][ncol]; // Decrease k if it's an obstacle
                    if (newK >= 0 && !vis[nrow][ncol][newK]) {
                        vis[nrow][ncol][newK] = true;
                        q.add(new State(nrow, ncol, steps + 1, newK));
                    }
                }
            }
        }
        
        return -1; 
    }
}
