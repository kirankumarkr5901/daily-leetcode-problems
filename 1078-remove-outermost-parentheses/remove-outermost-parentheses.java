class Solution {
    public String removeOuterParentheses(String s) {
        int level = 0;
        StringBuilder sb = new StringBuilder(s);

        for(int index = 0;index < sb.length();index++) {
            char c = sb.charAt(index);
            if(c == '(') {
                if(level == 0) {
                    sb.deleteCharAt(index);
                    index--;
                }
                level++;
            } else {
                level--;
                if(level == 0) {
                    sb.deleteCharAt(index);
                    index--;
                }
            }
        }
        return sb.toString();
    }
}