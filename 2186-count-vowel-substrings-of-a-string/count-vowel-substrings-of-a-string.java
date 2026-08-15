class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int countVowelSubstrings(String s) {
        int answer = 0;
        int left = 0;
        int current = 0;
        int n = s.length();
        int[] count = new int[26];
        int uniqueValues = 0;
        for(int right = 0;right < n;right++) {
            char c = s.charAt(right);
            if(isVowel(c)) {
                int index = c-'a';
                count[index]++;
                if(count[index] == 1)
                    uniqueValues++;
                
                while(uniqueValues == 5) {
                    int currIndex = s.charAt(current) - 'a';
                    count[currIndex]--;
                    if(count[currIndex] == 0)
                        uniqueValues--;
                    current++;
                }

                answer += (current - 1) - left + 1;

            } else {
                // reset
                left = right + 1;
                current = left;
                uniqueValues = 0;
                count = new int[26];
            }
        }
        return answer;
    }
}