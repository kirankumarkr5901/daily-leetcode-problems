class Solution {
    private static final int MOD = 1_000_000_007;
    private long[] sum;
    private long[] lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100_001];
        java.util.Arrays.fill(last, -1);

        long cur = 0; // sum of f[l]^2 over all l <= r
        long ans = 0;

        for (int r = 0; r < n; r++) {
            int p = last[nums[r]];
            long s = query(1, 0, n - 1, p + 1, r);
            cur = (cur + 2 * s + (r - p)) % MOD;
            update(1, 0, n - 1, p + 1, r, 1);
            ans = (ans + cur) % MOD;
            last[nums[r]] = r;
        }
        return (int) ans;
    }

    private void apply(int node, int l, int r, long v) {
        sum[node] += v * (r - l + 1);
        lazy[node] += v;
    }

    private void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int m = (l + r) >>> 1;
            apply(2 * node, l, m, lazy[node]);
            apply(2 * node + 1, m + 1, r, lazy[node]);
            lazy[node] = 0;
        }
    }

    private void update(int node, int l, int r, int ql, int qr, long v) {
        if (qr < l || r < ql) return;
        if (ql <= l && r <= qr) {
            apply(node, l, r, v);
            return;
        }
        push(node, l, r);
        int m = (l + r) >>> 1;
        update(2 * node, l, m, ql, qr, v);
        update(2 * node + 1, m + 1, r, ql, qr, v);
        sum[node] = sum[2 * node] + sum[2 * node + 1];
    }

    private long query(int node, int l, int r, int ql, int qr) {
        if (qr < l || r < ql) return 0;
        if (ql <= l && r <= qr) return sum[node];
        push(node, l, r);
        int m = (l + r) >>> 1;
        return query(2 * node, l, m, ql, qr) + query(2 * node + 1, m + 1, r, ql, qr);
    }
}