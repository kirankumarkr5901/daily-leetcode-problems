class Solution {

    int ans;
    int rows;
    int cols;
    boolean[][][] visited;

    private void solve(int[][] grid, int xor, int col, int row) {
        if(col > cols || row > rows) return;
        if (visited[row][col][xor]) return;
        visited[row][col][xor] = true;

        int currentXor = grid[row][col] ^ xor;
        if(col == cols && row == rows) {
            ans = Math.min(ans, currentXor);
            return;
        }
        solve(grid, currentXor, col, row+1);
        solve(grid, currentXor, col+1, row);
        
    }

    public int minCost(int[][] grid) {
        ans = Integer.MAX_VALUE;
        rows = grid.length-1;
        cols = grid[0].length-1;
        visited = new boolean[rows + 1][cols + 1][1024];
        solve(grid, 0, 0, 0);
        return ans;
    }
}