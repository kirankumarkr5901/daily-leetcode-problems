class Solution {
    public String minRemoveToMakeValid(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack();
        for(int i = 0;i < n;i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(i);
            } else if(c == ')') {
                if(!stack.isEmpty() && s.charAt(stack.peek()) == '(')
                    stack.pop();
                else
                    stack.push(i);
            }
        }

        StringBuilder sb = new StringBuilder(s);

        while(!stack.isEmpty())
            sb.deleteCharAt(stack.pop());
        
        return sb.toString();
    }
}