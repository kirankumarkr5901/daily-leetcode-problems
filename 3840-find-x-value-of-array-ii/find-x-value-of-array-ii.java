class Solution {
    private int k, n;
    private int[] prod;     // segment product mod k
    private int[][] cnt;    // cnt[node][r*k + v]
    private int curRes, ansVal;

    public int[] resultArray(int[] nums, int k, int[][] queries) {
        this.k = k;
        this.n = nums.length;
        prod = new int[4 * n];
        cnt = new int[4 * n][k * k];
        build(1, 0, n - 1, nums);

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int idx = queries[i][0], val = queries[i][1];
            int start = queries[i][2], x = queries[i][3];
            update(1, 0, n - 1, idx, val);
            curRes = 1 % k;          // handles k == 1
            ansVal = 0;
            query(1, 0, n - 1, start, x);
            res[i] = ansVal;
        }
        return res;
    }

    private void build(int node, int l, int r, int[] nums) {
        if (l == r) { setLeaf(node, nums[l]); return; }
        int mid = (l + r) >>> 1;
        build(node << 1, l, mid, nums);
        build(node << 1 | 1, mid + 1, r, nums);
        pull(node);
    }

    private void update(int node, int l, int r, int pos, int val) {
        if (l == r) { setLeaf(node, val); return; }
        int mid = (l + r) >>> 1;
        if (pos <= mid) update(node << 1, l, mid, pos, val);
        else update(node << 1 | 1, mid + 1, r, pos, val);
        pull(node);
    }

    // visits the nodes covering [ql, n-1] in left-to-right order
    private void query(int node, int l, int r, int ql, int x) {
        if (r < ql) return;
        if (l >= ql) {
            ansVal += cnt[node][curRes * k + x];
            curRes = (curRes * prod[node]) % k;
            return;
        }
        int mid = (l + r) >>> 1;
        query(node << 1, l, mid, ql, x);
        query(node << 1 | 1, mid + 1, r, ql, x);
    }

    private void setLeaf(int node, int val) {
        int p = val % k;
        prod[node] = p;
        int[] c = cnt[node];
        java.util.Arrays.fill(c, 0);
        for (int rr = 0; rr < k; rr++) c[rr * k + (rr * p) % k] = 1;
    }

    private void pull(int node) {
        int L = node << 1, R = node << 1 | 1;
        prod[node] = (prod[L] * prod[R]) % k;
        int[] c = cnt[node], cl = cnt[L], cr = cnt[R];
        for (int rr = 0; rr < k; rr++) {
            int shifted = (rr * prod[L]) % k;
            for (int v = 0; v < k; v++) {
                c[rr * k + v] = cl[rr * k + v] + cr[shifted * k + v];
            }
        }
    }
}