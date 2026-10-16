class Solution {
    int i = 0;
    int n = 0;
    private int getNumber(String s) {
        int number = 0;
        while(i < n && s.charAt(i) == ' ') i++;
        while(i < n && s.charAt(i) - '0' >= 0 && s.charAt(i) - '0' <= 9) {
            number *= 10;
            number += s.charAt(i) - '0';
            i++;
        }
        return number;
    }
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        
        i = 0;
        n = s.length();
        int sign = 1;
        while(i < n) {
            if(s.charAt(i) - '0' >= 0 && s.charAt(i)-'0' <= 9) {
                stack.push(getNumber(s)*sign);
            }
            while(i < n && s.charAt(i) == ' ') i++;
            if(i == n) break;
            char c = s.charAt(i);
            if(c == '+') {
                sign = 1;
                i++;
            } else if(c == '-') {
                sign = -1;
                i++;
            } else if(c == '*') {
                ++i;
                int result = stack.pop() * getNumber(s);
                stack.push(result);
            } else if(c == '/') {
                ++i;
                int result = stack.pop() / getNumber(s);
                stack.push(result);
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) {
            answer += stack.pop();
        }
        return answer;
    }
}