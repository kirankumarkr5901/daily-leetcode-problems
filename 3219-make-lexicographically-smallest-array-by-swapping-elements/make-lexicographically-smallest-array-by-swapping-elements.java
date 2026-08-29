class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        int n = nums.length;
        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) idx[i] = i;
        // Sort indices by their values
        Arrays.sort(idx, (a, b) -> Integer.compare(nums[a], nums[b]));

        int[] ans = new int[n];
        int start = 0;
        while (start < n) {
            // Extend the group while consecutive sorted values differ by <= limit
            int end = start + 1;
            while (end < n && nums[idx[end]] - nums[idx[end - 1]] <= limit) {
                end++;
            }
            // Collect original positions in this group and sort them ascending
            int[] positions = new int[end - start];
            for (int k = start; k < end; k++) positions[k - start] = idx[k];
            Arrays.sort(positions);
            // Place the sorted values (already sorted by idx order) into sorted positions
            for (int k = start; k < end; k++) {
                ans[positions[k - start]] = nums[idx[k]];
            }
            start = end;
        }
        return ans;
    }
}