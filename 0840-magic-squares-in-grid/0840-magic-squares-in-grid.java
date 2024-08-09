class Solution {
    public boolean helper(int[][] grid, int row, int col) {
        Set<Integer> uniqueNumbers = new HashSet<>();
        int[] rowSums = new int[3];
        int[] colSums = new int[3];
        int diagonalSum1 = 0;
        int diagonalSum2 = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                int num = grid[row + i][col + j];

                // Check if number is between 1 and 9
                if (num < 1 || num > 9) {
                    return false;
                }

                // Check if number is unique
                if (!uniqueNumbers.add(num)) {
                    return false;
                }

                // Update row and column sums
                rowSums[i] += num;
                colSums[j] += num;

                // Update diagonals
                if (i == j) {
                    diagonalSum1 += num;
                }
                if (i + j == 2) {
                    diagonalSum2 += num;
                }
            }
        }

        // Check if all sums are equal
        int magicSum = rowSums[0];
        for (int i = 1; i < 3; i++) {
            if (rowSums[i] != magicSum || colSums[i] != magicSum) {
                return false;
            }
        }
        return diagonalSum1 == magicSum && diagonalSum2 == magicSum;
    }

    public int numMagicSquaresInside(int[][] grid) {
        int ans = 0;
        int n = grid.length;
        int m = grid[0].length;

        for (int row = 0; row + 2 < n; row++) {
            for (int col = 0; col + 2 < m; col++) {
                if (helper(grid, row, col)) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
