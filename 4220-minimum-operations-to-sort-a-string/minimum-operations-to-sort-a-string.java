class Solution {
    public int minOperations(String s) {
        int n = s.length();
        if(n < 2) return 0;

        if(n == 2) {
            if (s.charAt(0) <= s.charAt(1)) return 0;
            return -1;
        }

        int smallIndex = 0;
        int bigIndex = 0;
        for(int i = 0;i<n;i++) {
            char c = s.charAt(i);
            if(c < s.charAt(smallIndex)) 
                smallIndex = i;
            
            if(c >= s.charAt(bigIndex))
                bigIndex = i;
        }
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        String t = new String(charArray);
        if(t.equals(s)) return 0;
        if(smallIndex == 0 || bigIndex == n-1) return 1;
        if(smallIndex == n-1 && bigIndex == 0) return 3;
        return 2;

    }
}