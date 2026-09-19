class Solution {
    private String answer = "";

    private boolean checkPalindrome(String s, int low, int high, int[][] dp) {
        if(low == high) {
            dp[low][high] = 1;
            if((high - low + 1) > answer.length()) {
                answer = s.substring(low, high+1);
            }
            return true;
        }
        if(dp[low][high] != 0) {
            return dp[low][high] == 1;
        }
        boolean isPalindrome = true;
        int dLow = low;
        int dHigh = high;
        while(dLow < dHigh) {
            if(s.charAt(dLow) != s.charAt(dHigh)) {
                isPalindrome = false;
                break;
            }
            dLow++;
            dHigh--;
        }
        if(isPalindrome) {
            dp[low][high] = 1;
            if((high - low +1) > answer.length()) {
                answer = s.substring(low, high+1);
            }
        }
        dp[low][high] = 2;
        checkPalindrome(s, low+1, high, dp);
        checkPalindrome(s, low, high-1, dp);
        return false;
    }
    public String longestPalindrome(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        checkPalindrome(s, 0, len-1, dp);
        return answer;
    }
}