class Solution {

    public String shortestBeautifulSubstring(String s, int k) {
        // BRUTE FORCE
        int n = s.length();
        if(n < k) {
            return "";
        }
        for(int len = k;len<=n;len++) {
            String ans = "";
            for(int i = 0;i<= (n-len);i++) {
                String temp = s.substring(i, i+len);
                int count1 = 0;
                for(char c: temp.toCharArray()) {
                    if(c == '1') {
                        count1++;
                    }
                }
                if(count1 == k) {
                    if(ans.equals("") || temp.compareTo(ans) < 0) {
                        ans = temp;
                    }
                    System.out.println(" -> "+ans);
                }
            }
            if(!ans.equals("")) {
                return ans;
            }
        }
        return "";
    }
}