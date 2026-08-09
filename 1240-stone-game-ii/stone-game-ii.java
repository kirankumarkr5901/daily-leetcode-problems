class Solution {

    private int getScore(boolean isAlice, int[] piles, int i, int M, int[][][] dp) {
        int n = piles.length;
        if(i == n) return 0;
        int isA = isAlice ? 0 : 1;
        if(dp[isA][i][M] != -1) {
            return dp[isA][i][M];
        }

        int answer = isAlice ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for(int x = 1;x <= 2*M && (i+x-1) < n;x++) {
            total += piles[i + x - 1];
            if (isAlice) {
                answer = Math.max(answer, total + getScore(!isAlice, piles, i+x, Math.max(x, M), dp));
            } else {
                answer = Math.min(answer, getScore(!isAlice, piles, i+x, Math.max(x, M), dp));
            }
        }
        dp[isA][i][M] = answer;
        return answer;
    }

    public int stoneGameII(int[] piles) {
        int n = piles.length;
        int[][][] dp = new int[2][n+1][n+1];
        for(int[][] twoD: dp) {
            for(int[] oneD: twoD) {
                Arrays.fill(oneD, -1);
            }
        }
        return getScore(true, piles, 0, 1, dp);
    }
}