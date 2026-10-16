class Solution {
    public int minLength(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty())
                stack.push(c);
            else if((c == 'B' && stack.peek() == 'A') || (c == 'D' && stack.peek() == 'C'))
                stack.pop();
            else
                stack.push(c);
        }
        return stack.size();
    }
}