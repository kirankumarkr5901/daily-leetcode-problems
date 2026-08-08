class Solution {
    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if(n < m) {
            return new int[0];
        }
        int[] right = new int[m];
        for(int i = n-1, j = m-1;i>=0;i--) {
            if(j >= 0 && word1.charAt(i) == word2.charAt(j)) {
                right[j] = i;
                j--;
            }
        }
        int[] answer = new int[m];
        int skip = 1;
        int j = 0;
        for(int i = 0,k = 0;i<n && j < m;i++) {
            if(word1.charAt(i) == word2.charAt(j) || (skip == 1 && (j == m-1 || i < right[j+1]))) {
                if(word1.charAt(i) != word2.charAt(j)) {
                    skip--;
                }
                answer[k] = i;
                k++;
                j++;
            }
        }
        return j == m ? answer : new int[0];
    }
}