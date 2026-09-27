class Solution {
    public String reverseParentheses(String s) {
        StringBuilder str = new StringBuilder(s);
        Stack<Integer> stack = new Stack();
        int n = s.length();

        for(int i = 0;i<n;i++) {
            if(s.charAt(i) == '(') {
                stack.add(i);
            } else if(s.charAt(i) == ')') {
                reverseString(str, stack.pop()+1, i-1);
            }
        }
        int index = 0;
        while(index < str.length()) {
            if(str.charAt(index) == '(' || str.charAt(index) == ')') {
                str.deleteCharAt(index);
                continue;
            }
            index++;
        }
        return str.toString();
    }

    private void reverseString(StringBuilder str, int start, int end) {
        while(start < end) {
            char c = str.charAt(end);
            str.setCharAt(end, str.charAt(start));
            str.setCharAt(start, c);
            start++;
            end--;
        }
    }
}