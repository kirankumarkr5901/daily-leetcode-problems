class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack();
        s += "+";
        int n = s.length();
        int number = 0;
        char op = '+';
        for(int i = 0;i<n;i++) {
            char c = s.charAt(i);
            if(Character.isDigit(c)) {
                number *= 10;
                number += (c - '0');
            }
            else if(c != ' ') {
                if(op == '+') {
                    stack.push(number);
                    number = 0;
                }
                else if(op == '-') {
                    stack.push(-number);
                    number = 0;
                }
                else if(op == '*') {
                    stack.push(stack.pop() * number);
                    number = 0;
                }
                else if(op == '/') {
                    stack.push(stack.pop() / number);
                    number = 0;
                }
                op = c;
            }
        }
        int answer = 0;
        while(!stack.isEmpty()) 
            answer += stack.pop();
        return answer;
    }
}