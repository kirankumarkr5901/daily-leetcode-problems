class Solution {

    private boolean solve(int n, int[] dp) {
        if(n == 0) return false;
        if(dp[n-1] != -1) return dp[n-1] == 1;

        for(int k = 1;k*k<=n;k++) {
            int squared = k*k;
            if(!solve(n-squared, dp)) {
                dp[n-1] = 1;
                return true;
            }
        }
        dp[n-1] = 0;
        return false;
    }

    public boolean winnerSquareGame(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return solve(n, dp);
    }
}