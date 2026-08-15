class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int countVowelSubstrings(String s) {
        int answer = 0;

        // BRUTE FORCE
        int[] count = new int[26];
        int uniqueValue = 0;
        int n = s.length();
        for(int i = 0;i<n;i++) {
            count = new int[26];
            uniqueValue = 0;
            for(int j = i;j<n && isVowel(s.charAt(j));j++) {
                count[s.charAt(j)-'a']++;
                if(count[s.charAt(j)-'a'] == 1)
                    uniqueValue++;
                if(uniqueValue == 5) {
                    answer++;
                }
            }
        }


        // SLIDING WINDOW
        // int left = 0;
        // int current = 0;
        // int n = s.length();
        // int[] count = new int[26];
        // int uniqueValues = 0;
        // for(int right = 0;right < n;right++) {
        //     char c = s.charAt(right);
        //     if(isVowel(c)) {
        //         int index = c-'a';
        //         count[index]++;
        //         if(count[index] == 1)
        //             uniqueValues++;
                
        //         while(uniqueValues == 5) {
        //             int currIndex = s.charAt(current) - 'a';
        //             count[currIndex]--;
        //             if(count[currIndex] == 0)
        //                 uniqueValues--;
        //             current++;
        //         }

        //         answer += (current - 1) - left + 1;

        //     } else {
        //         // reset
        //         left = right + 1;
        //         current = left;
        //         uniqueValues = 0;
        //         count = new int[26];
        //     }
        // }
        return answer;
    }
}