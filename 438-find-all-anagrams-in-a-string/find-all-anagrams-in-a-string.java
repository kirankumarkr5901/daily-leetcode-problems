class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> answer = new ArrayList();
        int[] countP = new int[26];
        for(char c: p.toCharArray()) {
            countP[c-'a']++;
        }
        int[] countS = new int[26];
        int k = p.length();
        int start = 0;
        int count = 0;
        for(int end = 0;end < s.length();end++) {
            char key = s.charAt(end);
            countS[key-'a']++;
            count++;
            if(count == k) {
                boolean isAna = true;
                for(int i = 0;i<26;i++) {
                    if(countS[i] != countP[i]) {
                        isAna = false;
                        break;
                    }
                }
                if(isAna) {
                    answer.add(start);
                }
                countS[s.charAt(start)-'a']--;
                count--;
                start++;
            }
        }
        return answer;
    }
}