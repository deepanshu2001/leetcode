class Solution {
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int vis[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                vis[i][j] = board[i][j];
            }
        }

        int deltarow[] = { -1, -1, -1, 0, 1, 1, 1, 0 };
        int deltacol[] ={ -1, 0, 1, 1, 1, 0, -1, -1 };

        // Traverse board to apply game rules
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = 0;
                
                for (int k = 0; k < 8; k++) {
                    int nrow = i + deltarow[k];
                    int ncol = j + deltacol[k];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] == 1) {
                        cnt++;
                    }
                }
                if (vis[i][j] == 0) { 
                    if (cnt == 3) {
                        board[i][j] = 1; 
                    }
                } else { 
                    if (cnt < 2 || cnt > 3) {
                        board[i][j] = 0;
                    }
                }
            }
        }

      
    }
}
