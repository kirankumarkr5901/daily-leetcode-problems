class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1000000000 + 7;
        long answer = 0;
        long[] dp = new long[26];
        for(char c: s.toCharArray()) {
            int index = c-'a';
            long current = (answer + 1);
            answer = (answer + current - dp[index] + MOD) % MOD;
            dp[c-'a'] = current;
        }
        return (int)answer;
    }
}