class Solution {

    class Cell {
        int row;
        int col;
        Cell(int r, int c) {
            row = r;
            col = c;
        }
    }
    public int orangesRotting(int[][] grid) {
        Queue<Cell> queue = new LinkedList();
        int rows = grid.length;
        int cols = grid[0].length;

        for(int i = 0;i<rows;i++) {
            for(int j = 0;j<cols;j++) {
                if(grid[i][j] == 2) queue.offer(new Cell(i,j));
            }
        }

        int size = queue.size();
        int minutes = 0;
        while(!queue.isEmpty()) {
            Cell cell = queue.poll();
            size--;
            int r = cell.row;
            int c = cell.col;

            if(c > 0 && grid[r][c-1] == 1){
                grid[r][c-1] = 2;
                queue.offer(new Cell(r, c-1));
            }
            if(c < cols-1 && grid[r][c+1] == 1) {
                grid[r][c+1] = 2;
                queue.offer(new Cell(r, c+1));
            }
            if(r > 0 && grid[r-1][c] == 1) {
                grid[r-1][c] = 2;
                queue.offer(new Cell(r-1, c));
            }
            if( r < rows-1 && grid[r+1][c] == 1) {
                grid[r+1][c] = 2;
                queue.offer(new Cell(r+1, c));
            }

            if(size == 0) {
                size = queue.size();
                if(size > 0)
                    minutes++;
            }
        }

        for(int i = 0;i<rows;i++) {
            for(int j = 0;j<cols;j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return minutes;
    }
}