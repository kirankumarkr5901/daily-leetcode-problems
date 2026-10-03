class Solution {
    public int longestValidParentheses(String s) {
        int open = 0;
        int close = 0;
        int ans = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            char c = s.charAt(i);

            if(c == '(') open++;
            else close++;

            if(open == close) ans = Math.max(ans, 2 * close);
            else if(close > open) {
                open = 0;
                close = 0;
            }
        }
        open = 0;
        close = 0;
        for(int i = n-1;i>=0;i--) {
            char c = s.charAt(i);

            if(c == ')') close++;
            else open++;

            if(open == close) ans = Math.max(ans, 2 * close);
            else if(open > close) {
                open = 0;
                close = 0;
            }
        }
        return ans;
    }
}