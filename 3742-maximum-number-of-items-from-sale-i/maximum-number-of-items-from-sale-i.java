class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int maxF = 0;
        for (int[] it : items) maxF = Math.max(maxF, it[0]);

        // cnt[v] = number of items whose factor equals v
        int[] cnt = new int[maxF + 1];
        for (int[] it : items) cnt[it[0]]++;

        // multiples[f] = number of items whose factor is divisible by f
        int[] multiples = new int[maxF + 1];
        for (int f = 1; f <= maxF; f++) {
            for (int m = f; m <= maxF; m += f) multiples[f] += cnt[m];
        }

        int[] dp = new int[budget + 1]; // dp[b] = max items with spend <= b

        for (int[] it : items) {
            int factor = it[0], price = it[1];
            // First copy: itself + one free copy of every other item it divides
            int firstGain = multiples[factor]; // includes itself, so it's 1 + free copies

            // 0/1 knapsack: the first copy can be bought at most once
            for (int b = budget; b >= price; b--) {
                dp[b] = Math.max(dp[b], dp[b - price] + firstGain);
            }
            // Unbounded knapsack: each extra copy adds exactly 1
            for (int b = price; b <= budget; b++) {
                dp[b] = Math.max(dp[b], dp[b - price] + 1);
            }
        }
        return dp[budget];
    }
}