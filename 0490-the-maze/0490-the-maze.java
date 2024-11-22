class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        int m = maze[0].length;
        boolean[][] vis = new boolean[n][m];
        return dfs(maze, vis, start[0], start[1], destination[0], destination[1]);
    }

    public boolean dfs(int[][] maze, boolean[][] vis, int row, int col, int destRow, int destCol) {
        if (vis[row][col]) {
            return false;
        }
        if (row == destRow && col == destCol) {
            return true;
        }
        vis[row][col] = true;
        int n = maze.length;
        int m = maze[0].length;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {
            int newRow = row;
            int newCol = col;
            // Roll the ball until it hits a wall
            while (newRow + deltaRow[i] >= 0 && newRow + deltaRow[i] < n &&
                   newCol + deltaCol[i] >= 0 && newCol + deltaCol[i] < m &&
                   maze[newRow + deltaRow[i]][newCol + deltaCol[i]] == 0) {
                newRow += deltaRow[i];
                newCol += deltaCol[i];
            }
            if (dfs(maze, vis, newRow, newCol, destRow, destCol)) {
                return true;
            }
        }
        return false;
    }
}
