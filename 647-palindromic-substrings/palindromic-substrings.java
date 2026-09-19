class Solution {
    private int answer = 0;

    private boolean checkPalindrome(String s, int low, int high, int[][] dp) {
        if(dp[low][high] != 0) {
            return dp[low][high] == 1;
        }
        if(low == high) {
            dp[low][high] = 1;
            answer++;
            return true;
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
            answer++;
            dp[low][high] = 1;
        } else {
            dp[low][high] = 2;
        }
        checkPalindrome(s, low+1, high, dp);
        checkPalindrome(s, low, high-1, dp);
        return dp[low][high] == 1;

    }

    public int countSubstrings(String s) {
        int len = s.length();
        int[][] dp = new int[len][len];
        checkPalindrome(s, 0, len-1, dp);
        return answer;
    }
}