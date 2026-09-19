class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int rows = mat.length;
        int cols = mat[0].length;
        int[][] prefix = new int[rows+1][cols+1];
        for(int i = 1;i<=rows;i++) {
            for(int j = 1;j<=cols;j++) {
                prefix[i][j] = mat[i-1][j-1] + prefix[i-1][j] + prefix[i][j-1] - prefix[i-1][j-1];
            }
        }
        int[][] answer = new int[rows][cols];

        for(int i = 0;i<rows;i++) {
            for(int j = 0;j<cols;j++) {
                int r1 = Math.max(i-k, 0);
                int c1 = Math.max(j-k, 0);
                int r2 = Math.min(i+k, rows-1);
                int c2 = Math.min(j+k, cols-1);
                answer[i][j] = prefix[r2+1][c2+1] - prefix[r2+1][c1] - prefix[r1][c2+1] + prefix[r1][c1];
            }
        }
        return answer;
    }
}