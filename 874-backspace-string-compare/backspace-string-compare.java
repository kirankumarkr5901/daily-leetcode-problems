class Solution {
    public boolean backspaceCompare(String s, String t) {
        StringBuilder a = new StringBuilder();
        StringBuilder b = new StringBuilder();
        int validChars = 0;
        for(char c: s.toCharArray()) {
            if(c == '#' && validChars > 0) {
                a.deleteCharAt(validChars-1);
                validChars--;
            } else if(c != '#'){
                a.append(c);
                validChars++;
            }
        }
        validChars = 0;
        for(char c: t.toCharArray()) {
            if(c == '#' && validChars > 0) {
                b.deleteCharAt(validChars-1);
                validChars--;
            } else if(c != '#'){
                b.append(c);
                validChars++;
            }
        }
        return a.toString().equals(b.toString());
    }
}