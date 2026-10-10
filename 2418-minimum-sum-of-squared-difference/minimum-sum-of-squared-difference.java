class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        int[] diff = new int[n];

        long sum = 0;
        int maxDiff = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = Math.abs(nums1[i] - nums2[i]);
            sum += diff[i];
            maxDiff = Math.max(maxDiff, diff[i]);
        }

        long k = (long) k1 + k2;

        if (sum <= k) {
            return 0L;
        }

        int left = 0, right = maxDiff;

        while (left < right) {
            int mid = left + (right - left) / 2;

            long need = 0;
            for (int d : diff) {
                if (d > mid) {
                    need += d - mid;
                }
            }

            if (need <= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        int limit = left;

        // Reduce everything above limit
        for (int i = 0; i < n; i++) {
            if (diff[i] > limit) {
                k -= diff[i] - limit;
                diff[i] = limit;
            }
        }

        // Use remaining operations
        for (int i = 0; i < n && k > 0; i++) {
            if (diff[i] == limit && diff[i] > 0) {
                diff[i]--;
                k--;
            }
        }

        long ans = 0;
        for (int d : diff) {
            ans += 1L * d * d;
        }

        return ans;
    }
}