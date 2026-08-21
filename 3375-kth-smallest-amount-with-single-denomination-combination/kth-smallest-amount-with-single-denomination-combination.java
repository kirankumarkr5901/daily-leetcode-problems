import java.util.Arrays;

class Solution {
    public long findKthSmallest(int[] coins, int k) {
        long lo = 1;
        long hi = (long) k * Arrays.stream(coins).min().getAsInt();

        while (lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if (countUpTo(coins, mid) >= k) {
                hi = mid;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    // count of achievable amounts <= x, via inclusion-exclusion over subsets (using LCM)
    private long countUpTo(int[] coins, long x) {
        int n = coins.length;
        long count = 0;

        for (int mask = 1; mask < (1 << n); mask++) {
            long lcm = 1;
            boolean exceeded = false;

            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    lcm = lcm(lcm, coins[i]);
                    if (lcm > x) {
                        exceeded = true;
                        break;
                    }
                }
            }
            if (exceeded) {
                continue;
            }

            int bits = Integer.bitCount(mask);
            long term = x / lcm;
            count += (bits % 2 == 1) ? term : -term;
        }
        return count;
    }

    private long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b) {
        return a / gcd(a, b) * b;
    }
}