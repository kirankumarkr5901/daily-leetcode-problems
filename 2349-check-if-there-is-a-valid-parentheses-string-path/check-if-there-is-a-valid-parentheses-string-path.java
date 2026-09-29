class Solution {

    boolean[][][] dp;
    int rows;
    int cols;

    private boolean isValid(char[][] grid, int row, int col, int balance) {
        if(row >= rows || col >= cols) return false;

        balance += grid[row][col] == '(' ? 1 : -1;

        if(balance < 0) {
            return false;
        }

        if(row == rows-1 && col == cols-1)
            return balance == 0;
        
        if(dp[row][col][balance]) return false;
        dp[row][col][balance] = true;

        boolean result = isValid(grid, row+1, col, balance) || isValid(grid, row, col+1, balance);
        return result;
    }

    public boolean hasValidPath(char[][] grid) {
        rows = grid.length;
        cols = grid[0].length;
        dp = new boolean[rows+1][cols+1][rows+cols];
        return isValid(grid, 0, 0, 0);
    }
}