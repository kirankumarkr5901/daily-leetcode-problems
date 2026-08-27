class Solution {
    String answer = "";
    private boolean getGreater(StringBuilder curr, String target, int index, boolean greater, int[] count) {
        if(index == target.length()) {
            if(greater) {
                answer = String.valueOf(curr);
                return true;
            }
            return false;
        }

        for(char c = 'a';c<='z';c++) {
            if(count[c-'a'] == 0) continue;

            if(!greater && c < target.charAt(index)) continue;

            curr.append(c);
            count[c-'a']--;
            boolean isGreater = greater || c > target.charAt(index);

            if(getGreater(curr, target, index+1, isGreater, count)) return true;

            curr.deleteCharAt(curr.length() - 1);
            count[c-'a']++;
        }
        return false;
    }
    public String lexGreaterPermutation(String s, String target) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) count[c-'a']++;

        StringBuilder curr = new StringBuilder();
        getGreater(curr, target, 0, false, count);
        return answer;
    }
}