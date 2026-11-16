class Solution {
    private String getSum(String s) {
        int sum = 0;
        for(char c: s.toCharArray())
            sum += (c - '0');
        return String.valueOf(sum);
    }
    public String digitSum(String s, int k) {
        StringBuilder s1 = new StringBuilder(s);
        StringBuilder s2 = new StringBuilder();
        while(s1.length() > k) {
            int len = s1.length();
            for(int i = 0, j = k; i < len; i += k, j += k) {
                int end = j < len ? j : len;
                s2.append(getSum(s1.toString().substring(i, end)));
            }
            s1 = new StringBuilder(s2.toString());
            s2 = new StringBuilder();
        }
        return s1.toString();
    }
}