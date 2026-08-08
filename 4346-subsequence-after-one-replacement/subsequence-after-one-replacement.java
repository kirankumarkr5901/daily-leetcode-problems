class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(m < n) {
            return false;
        }
        if(n == 0) {
            return true;
        }
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        for(int i = 0, j = 0;i<n;i++, j++) {
            while(j < m && s.charAt(i) != t.charAt(j)) {
                j++;
            }
            if(j == m) {
                break;
            }
            left[i] = j;
        }
        if(left[n-1] != -1) {
            return true;
        }
        for(int i = n-1, j = m-1;i>=0;i--, j--) {
            while(j>= 0 && s.charAt(i) != t.charAt(j)) {
                j--;
            }
            if(j == -1) {
                break;
            }
            right[i] = j;
        }
        for(int i = 0;i<n;i++) {
            if ((i == 0 || left[i - 1] != -1) && (i == n - 1 || right[i + 1] != -1)) {
                int leftPart = i == 0 ? -1 : left[i-1];
                int rightPart = i == n-1 ? m : right[i+1];
                if(leftPart + 1 < rightPart) {
                    return true;
                }
            }
        }
        return false;
    }
}