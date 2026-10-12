class Solution {
    public int maxSum(List<Integer> nums, int k) {
        final long MOD = 1_000_000_007L;
        int[] cnt = new int[31];                 // nums[i] <= 1e9 < 2^30, 31 is safe

        for (int x : nums)
            for (int b = 0; b < 31; b++)
                if ((x >> b & 1) == 1) cnt[b]++;

        long ans = 0;
        for (int t = 0; t < k; t++) {
            long x = 0;
            for (int b = 0; b < 31; b++) {
                if (cnt[b] > 0) {
                    x |= 1L << b;
                    cnt[b]--;
                }
            }
            ans = (ans + x * x % MOD) % MOD;
        }
        return (int) ans;
    }
}