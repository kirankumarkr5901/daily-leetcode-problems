class Solution {
    int index=0;
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int number = 0;
        int n = s.length();
        for(;index<n;index++) {
            char c = s.charAt(index);
            if(Character.isDigit(c)) {
                number *= 10;
                number += c - '0';
            } else if(c == '[') {
                index++;
                String string = decodeString(s);
                for(int i = 0;i<number;i++)
                    sb.append(string);
                number = 0;
            } else if(c == ']') {
                return sb.toString();
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}