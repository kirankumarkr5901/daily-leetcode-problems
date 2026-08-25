class Solution {
    public int maxProductPath(int[][] grid) {
        final int MOD = 1000000000 + 7;
        int n = grid.length;
        int m = grid[0].length;
        long[][] maxProd = new long[n][m];
        long[][] minProd = new long[n][m];

        maxProd[0][0] = minProd[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            maxProd[0][i] = minProd[0][i] = maxProd[0][i - 1] * grid[0][i];
        }
        for (int i = 1; i < n; i++) {
            maxProd[i][0] = minProd[i][0] = maxProd[i - 1][0] * grid[i][0];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (grid[i][j] >= 0) {
                    maxProd[i][j] = Math.max(maxProd[i][j - 1], maxProd[i - 1][j]) * grid[i][j];
                    minProd[i][j] = Math.min(minProd[i][j - 1], minProd[i - 1][j]) * grid[i][j];
                } else {
                    maxProd[i][j] = Math.min(minProd[i][j - 1], minProd[i - 1][j]) * grid[i][j];
                    minProd[i][j] = Math.max(maxProd[i][j - 1], maxProd[i - 1][j]) * grid[i][j];
                }
            }
        }
        if (maxProd[n - 1][m - 1] < 0) {
            return -1;
        } else {
            return (int) (maxProd[n - 1][m - 1] % MOD);
        }
    }
}