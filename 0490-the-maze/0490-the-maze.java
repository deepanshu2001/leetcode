class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int n = maze.length;
        if (n == 0) return false;
        int m = maze[0].length;
        boolean[][] visited = new boolean[n][m];

        // Directions: up, right, down, left
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start[0], start[1]});
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int currRow = curr[0];
            int currCol = curr[1];

            // Check if the destination is reached
            if (currRow == destination[0] && currCol == destination[1]) {
                return true;
            }

            // Explore all four directions
            for (int i = 0; i < 4; i++) {
                int newRow = currRow;
                int newCol = currCol;

                // Roll the ball until it hits a wall
                while (isValid(newRow + deltaRow[i], newCol + deltaCol[i], maze)) {
                    newRow += deltaRow[i];
                    newCol += deltaCol[i];
                }

                // If the new position hasn't been visited, enqueue it
                if (!visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Destination cannot be reached
        return false;
    }

    // Helper method to check if the next position is within bounds and not a wall
    private boolean isValid(int row, int col, int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        return row >= 0 && row < n && col >= 0 && col < m && maze[row][col] == 0;
    }
}
