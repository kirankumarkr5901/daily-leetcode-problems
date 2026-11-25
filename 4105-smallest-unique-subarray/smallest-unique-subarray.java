import java.util.*;

class Solution {
    private static final long BASE = 1000003L;

    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 1, right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (check(nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean check(int[] nums, int len) {
        int n = nums.length;
        Map<Long, Integer> map = new HashMap<>();

        long hash = 0;
        long power = 1;

        for (int i = 0; i < len; i++) {
            hash = hash * BASE + nums[i];
            if (i < len - 1) {
                power *= BASE;
            }
        }

        map.put(hash, 1);

        for (int i = len; i < n; i++) {
            hash -= nums[i - len] * power;
            hash = hash * BASE + nums[i];

            map.put(hash, map.getOrDefault(hash, 0) + 1);
        }

        for (int count : map.values()) {
            if (count == 1) {
                return true;
            }
        }

        return false;
    }
}