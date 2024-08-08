class Solution {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int count = 0;
        
        // Directions: right, down, left, up
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        
        // Start position
        int r = rStart;
        int c = cStart;
        
        result[count++] = new int[]{r, c};
        
        if (rows * cols == 1) return result;  // Edge case for single element
        
        // Length of current leg of spiral
        int legLength = 1;

        while (count < rows * cols) {
            for (int i = 0; i < 4; i++) { // Four directions
                for (int j = 0; j < legLength; j++) {
                    r += dr[i];
                    c += dc[i];
                    
                    // If the new cell is within bounds, add it to the result
                    if (r >= 0 && r < rows && c >= 0 && c < cols) {
                        result[count++] = new int[]{r, c};
                    }
                }
                // Increase leg length after going right and left
                if (i == 1 || i == 3) legLength++;
            }
        }
        
        return result;
    }
}
