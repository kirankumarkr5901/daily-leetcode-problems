class Solution {

    String answer = "";
    String singleChar = "";
    
    private boolean palindromePerm(StringBuilder curr, String target, int index, int[] count, boolean greater) {
        int n = target.length() / 2;
        if(index == n) {
            StringBuilder palidrome = new StringBuilder(curr);
            StringBuilder right = new StringBuilder(palidrome).reverse();

            if (!singleChar.isEmpty()) {
                palidrome.append(singleChar);
            }
            palidrome.append(right);
            if(palidrome.toString().compareTo(target) > 0) {
                answer = palidrome.toString();
                return true;
            }
            return false;
        }
        for(char c = 'a';c<='z';c++) {
            if(count[c-'a']==0) continue;
            if(!greater && c < target.charAt(index)) continue;

            curr.append(c);
            count[c-'a']--;

            boolean isGreater = greater || c > target.charAt(index);
            if(palindromePerm(curr, target, index+1, count, isGreater)) return true;

            curr.deleteCharAt(curr.length() - 1);
            count[c-'a']++;
        }
        return false;
    }

    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];
        for(char c: s.toCharArray()) {
            count[c-'a']++;
        }
        boolean oddFound = false;
        for(int index = 0;index<26;index++) {
            if(count[index] % 2 == 1) {
                if(!oddFound) {
                    oddFound = true;
                    singleChar = String.valueOf((char)('a'+index));
                } else {
                    return answer;
                }
            }
            count[index] /= 2;
        }
        StringBuilder curr = new StringBuilder("");
        palindromePerm(curr, target, 0, count, false);
        return answer;
    }
}