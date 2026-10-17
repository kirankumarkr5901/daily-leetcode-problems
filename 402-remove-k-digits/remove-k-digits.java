class Solution {
    public String removeKdigits(String num, int k) {
        StringBuilder sb = new StringBuilder();
        for(char c: num.toCharArray()) {
            while(k > 0 && sb.length() > 0 && sb.charAt(sb.length() - 1) > c) {
                sb.deleteCharAt(sb.length()-1);
                k--;
            }
            sb.append(c);
        }
        int index = 0;
        int n = sb.length() - k;
        while(index < n && sb.charAt(index) == '0') index++;
        String res = sb.toString().substring(index, n);
        return res.isEmpty() ? "0" : res;
    }
}