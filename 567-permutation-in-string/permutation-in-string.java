class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] count1 = new int[26];
        for(char c: s1.toCharArray()) {
            count1[c-'a']++;
        }
        int k = s1.length();
        int start = 0;
        int count = 0;
        int[] count2 = new int[26];
        for(int end = 0;end < s2.length();end++) {
            char endKey = s2.charAt(end);
            count2[endKey-'a']++;
            count++;
            if(count == k) {
                boolean isPerm = true;
                for(int i = 0;i<26;i++) {
                    if(count1[i] != count2[i]) {
                        isPerm = false;
                        break;
                    }
                }
                if(isPerm){
                    return true;
                }
                count2[s2.charAt(start) - 'a']--;
                count--;
                start++;
            }
        }
        return false;
    }
}