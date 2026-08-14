class Solution {
    public int maximumLengthSubstring(String s) {
        int[] count = new int[26];
        int ans = 0;
        int n = s.length();
        for(int left = 0, right = 0;right < n;right++) {
            int currentIndex = s.charAt(right) - 'a';
            count[currentIndex]++;
            while(count[currentIndex] > 2) {
                int leftIndex = s.charAt(left) - 'a';
                count[leftIndex]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}