class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int[] cnt = new int[n + 1];
        long m = Long.MAX_VALUE;
        for (int[] it : items) {
            cnt[it[0]]++;
            m = Math.min(m, it[1]);
        }

        long[] multiples = new long[n + 1];
        for (int f = 1; f <= n; f++) {
            if (cnt[f] == 0) continue;
            for (int g = f; g <= n; g += f) multiples[f] += cnt[g];
        }

        int[][] sorted = items.clone();
        java.util.Arrays.sort(sorted, (a, b) -> Integer.compare(a[1], b[1]));

        long remaining = budget, total = 0;
        for (int[] it : sorted) {
            long p = it[1];
            if (p >= 2 * m || p > remaining) break;
            long d = multiples[it[0]] - 1;
            if (d == 0) continue;
            long take = Math.min(d, remaining / p);
            total += 2 * take;
            remaining -= take * p;
        }
        return (int) (total + remaining / m);
    }
}