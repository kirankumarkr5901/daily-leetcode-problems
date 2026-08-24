class Solution {

    private int solve(int i,int n, int[] stones, int[] dp) {
        if(i == n-1) {
            return stones[i];
        }
        if(dp[i] != -1) {
            return dp[i];
        }
        int take = stones[i] - solve(i+1, n, stones, dp);
        int skip = solve(i+1, n, stones, dp);
        return dp[i] = Math.max(take, skip);
    }

    public int stoneGameVIII(int[] stones) {
        // RECURSION
        int n = stones.length;
        // int[] dp = new int[n-1];
        for(int i = 1;i<n;i++) {
            stones[i] = stones[i] + stones[i-1];
        }
        // Arrays.fill(dp, -1);
        // return solve(1,n, stones, dp);

        // BOTTOM UP
        int[] sol = new int[n];
        sol[n-1] = stones[n-1];
        for(int i = n-2; i>=1;i--) {
            int take = stones[i] - sol[i+1];
            int skip = sol[i+1];
            sol[i] = Math.max(take, skip);
        }
        return sol[1];
    }
}