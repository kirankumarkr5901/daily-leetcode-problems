class Solution {
    public int maximumLengthSubstring(String s) {
        // SLIDING WINDOW
        // int[] count = new int[26];
        // int ans = 0;
        // int n = s.length();
        // for(int left = 0, right = 0;right < n;right++) {
        //     int currentIndex = s.charAt(right) - 'a';
        //     count[currentIndex]++;
        //     while(count[currentIndex] > 2) {
        //         int leftIndex = s.charAt(left) - 'a';
        //         count[leftIndex]--;
        //         left++;
        //     }
        //     ans = Math.max(ans, right - left + 1);
        // }
        // return ans;

        // BRUTE FORCE
        int ans = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            int[] count = new int[26];
            for(int j = i;j<n;j++) {
                int index = s.charAt(j) - 'a';
                count[index]++;
                if(count[index] > 2) {
                    break;
                }
                ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}