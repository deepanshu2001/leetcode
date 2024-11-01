class Solution {
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        int n = matrix.length;
        int m = matrix[0].length;
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == '1') {
                    int currentSide = 1;  // Start with a 1x1 square
                    boolean isSquare = true;
                    
                    // Attempt to expand the square
                    while (i + currentSide < n && j + currentSide < m && isSquare) {
                        // Check the new row and column to form a square
                        for (int k = 0; k <= currentSide; k++) {
                            if (matrix[i + currentSide][j + k] == '0' || matrix[i + k][j + currentSide] == '0') {
                                isSquare = false;
                                break;
                            }
                        }
                        
                        // If it's still a square, increase the side length
                        if (isSquare) {
                            currentSide++;
                        }
                    }
                    
                    maxSide = Math.max(maxSide, currentSide);
                }
            }
        }
        
        // Return the area of the largest square
        return maxSide * maxSide;
    }
}
