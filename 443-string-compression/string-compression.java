class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int curr = 0;
        int next = 0;
        int n = chars.length;
        while(next < n) {
            int count = 0;
            while(next < n && chars[next] == chars[curr]) {
                count++;
                next++;
            }
            chars[index++] = chars[curr];
            if(count > 1) {
                String str = String.valueOf(count);
                for(int i = 0;i<str.length();i++) {
                    chars[index++] = str.charAt(i);
                }
            }
            curr = next;
        }
        return index;
    }
}