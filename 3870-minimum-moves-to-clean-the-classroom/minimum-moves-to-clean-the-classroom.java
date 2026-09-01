class Solution {
    public int minMoves(String[] classroom, int energyCap) {
        int m = classroom.length, n = classroom[0].length();
        char[][] grid = new char[m][n];
        for (int i = 0; i < m; i++) grid[i] = classroom[i].toCharArray();

        int sx = -1, sy = -1;
        List<int[]> litterPositions = new ArrayList<>();
        int[][] litterIndex = new int[m][n];
        for (int[] row : litterIndex) Arrays.fill(row, -1);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i][j];
                if (c == 'S') {
                    sx = i;
                    sy = j;
                } else if (c == 'L') {
                    litterIndex[i][j] = litterPositions.size();
                    litterPositions.add(new int[]{i, j});
                }
            }
        }

        int litterCount = litterPositions.size();
        int fullMask = (1 << litterCount) - 1;
        if (fullMask == 0) return 0;

        // bestEnergy[i][j][mask] = max energy previously achieved at that state
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int[][] a : bestEnergy) for (int[] b : a) Arrays.fill(b, -1);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // state: x, y, mask, energy, steps
        bestEnergy[sx][sy][0] = energyCap;
        queue.offer(new int[]{sx, sy, 0, energyCap, 0});

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], mask = cur[2], e = cur[3], steps = cur[4];

            if (e == 0) continue; // stuck, no energy to move

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d], ny = y + dy[d];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if (grid[nx][ny] == 'X') continue;

                int ne = e - 1;
                int nmask = mask;
                if (grid[nx][ny] == 'L') {
                    nmask = mask | (1 << litterIndex[nx][ny]);
                }
                if (grid[nx][ny] == 'R') {
                    ne = energyCap; // reset happens on arrival, regardless of leftover energy
                }

                if (ne > bestEnergy[nx][ny][nmask]) {
                    bestEnergy[nx][ny][nmask] = ne;
                    if (nmask == fullMask) return steps + 1;
                    queue.offer(new int[]{nx, ny, nmask, ne, steps + 1});
                }
            }
        }

        return -1;
    }
}