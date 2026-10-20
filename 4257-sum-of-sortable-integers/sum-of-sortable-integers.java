class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] drops = new int[n];

        // Prefix maximum
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
        }

        // Suffix minimum
        suffMin[n] = Integer.MAX_VALUE;

        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(suffMin[i + 1], nums[i]);
        }

        // drops[i] = number of descents nums[j-1] > nums[j]
        // from index 1 to i
        for (int i = 1; i < n; i++) {
            drops[i] = drops[i - 1];

            if (nums[i - 1] > nums[i]) {
                drops[i]++;
            }
        }

        int ans = 0;

        for (int k = 1; k <= n; k++) {

            if (n % k != 0)
                continue;

            boolean valid = true;

            for (int start = 0; start < n; start += k) {

                int end = start + k - 1;

                // descents inside this block
                int count = drops[end] - drops[start];

                // circular descent: last -> first
                if (nums[end] > nums[start]) {
                    count++;
                }

                if (count > 1) {
                    valid = false;
                    break;
                }

                // Elements before this block must not be greater
                // than elements after this block.
                if (start > 0 &&
                    prefMax[start] > suffMin[start]) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                ans += k;
            }
        }

        return ans;
    }
}