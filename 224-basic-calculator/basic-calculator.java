class Solution {
    public int calculate(String s) {
        int number = 0;
        int ans = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack();

        int index = 0;
        int n = s.length();
        while(index < n) {
            while(index < n && (s.charAt(index) - '0') >= 0 && (s.charAt(index) - '0') <= 9) {
                number *= 10;
                number += (s.charAt(index) - '0');
                index++;
            }
            if(index == n) {
                break;
            }
            char c = s.charAt(index);
            if(c == '+') {
                ans += (sign * number);
                number = 0;
                sign = 1;
            } else if(c == '-') {
                ans += (sign * number);
                number = 0;
                sign = -1;
            } else if(c == '(') {
                ans += (sign * number);
                number = 0;
                stack.push(ans);
                stack.push(sign);
                ans = 0;
                sign = 1;
            } else if(c == ')') {
                ans += (sign * number);
                number = 0;
                ans *= stack.pop();
                ans += stack.pop();
                sign = 1;
            }
            index++;
        }
        if(index == n && number != 0)
            ans += (sign * number);
        return ans;
    }
}