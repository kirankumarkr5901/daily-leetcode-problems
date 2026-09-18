import java.util.*;

class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, n);

        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            left[idx] = Math.min(left[idx], i);
            right[idx] = i;
        }

        List<String> result = new ArrayList<>();
        int prevEnd = -1;
        for (int i = 0; i < n; i++) {
            if (i != left[s.charAt(i) - 'a']) {
                continue;
            }
            int end = getRightBound(s, i, left, right);
            if (end == -1) {
                continue;
            }
            if (i > prevEnd) {
                result.add(s.substring(i, end + 1));
            } else {
                result.set(result.size() - 1, s.substring(i, end + 1));
            }
            prevEnd = end;
        }
        return result;
    }

    private int getRightBound(String s, int start, int[] left, int[] right) {
        int end = right[s.charAt(start) - 'a'];
        for (int i = start; i <= end; i++) {
            int idx = s.charAt(i) - 'a';
            if (left[idx] < start) {
                return -1;
            }
            end = Math.max(end, right[idx]);
        }
        return end;
    }
}