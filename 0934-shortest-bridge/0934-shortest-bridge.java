import java.util.*;

class Solution {
    int n = 0;
    int m = 0;
    int vis[][];
    int deltarow[] = {-1, 0, 1, 0};
    int deltacol[] = {0, 1, 0, -1};

    public void dfs(int row, int col, int[][] grid) {
        vis[row][col] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = row + deltarow[i];
            int ncol = col + deltacol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(nrow, ncol, grid);
            }
        }
    }

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];
        boolean flag = false;

        // Step 1: Use DFS to mark all cells of the first island
        for (int i = 0; i < n; i++) {
            if (flag) break;
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid);
                    flag = true;
                    break;
                }
            }
        }

        // Step 2: Prepare for BFS by adding all cells of the first island to the queue
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});  // {row, col, distance}
                }
            }
        }

        // Step 3: Use BFS to find the shortest path to the second island
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0];
            int col = cell[1];
            int dist = cell[2];

            for (int i = 0; i < 4; i++) {
                int nrow = row + deltarow[i];
                int ncol = col + deltacol[i];

                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 0) {
                    if (grid[nrow][ncol] == 1) {
                        // Reached the second island
                        return dist;
                    } else if (grid[nrow][ncol] == 0) {
                        // Water cell, continue BFS
                        vis[nrow][ncol] = 1;
                        q.offer(new int[]{nrow, ncol, dist + 1});
                    }
                }
            }
        }

        return -1;  // Should not reach here
    }
}
