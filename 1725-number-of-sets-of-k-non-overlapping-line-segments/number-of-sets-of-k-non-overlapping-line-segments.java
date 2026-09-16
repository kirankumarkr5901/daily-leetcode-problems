class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfSets(int n, int k) {
        return comb(n + k - 1, 2 * k);
    }

    private int comb(int n, int r) {
        if (r < 0 || r > n) return 0;
        r = Math.min(r, n - r);
        long res = 1;
        for (int i = 1; i <= r; i++) {
            res = res * ((n - r + i) % MOD) % MOD;   // numerator term
            res = res * modPow(i, MOD - 2) % MOD;    // divide by i via Fermat
        }
        return (int) res;
    }

    private long modPow(long b, long e) {
        long r = 1; b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }
}