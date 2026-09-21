class Solution {
    public long[] resultArray(int[] nums, int k) {
        long[] result = new long[k];
        // dp[r] = number of subarrays ending at the current index whose product % k == r
        long[] dp = new long[k];
        long[] next = new long[k];

        for (int num : nums) {
            int m = num % k;
            Arrays.fill(next, 0L);

            // Extend every subarray that ended at the previous index.
            for (int r = 0; r < k; r++) {
                if (dp[r] != 0) {
                    next[(r * m) % k] += dp[r];
                }
            }
            // The length-1 subarray consisting of num alone.
            next[m]++;

            for (int r = 0; r < k; r++) {
                result[r] += next[r];
            }

            long[] tmp = dp;
            dp = next;
            next = tmp;
        }
        return result;
    }
}