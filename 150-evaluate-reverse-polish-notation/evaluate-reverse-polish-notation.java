class Solution {
    private boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack();
        for(String str: tokens) {
            if(isInteger(str)) {
                stack.push(Integer.parseInt(str));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int c = 0;
                if(str.equals("+")) {
                    c = a+b;
                } else if(str.equals("-")) {
                    c = a-b;
                } else if(str.equals("*")) {
                    c = a*b;
                } else {
                    c = a/b;
                }
                stack.push(c);
            }
        }
        return stack.pop();
    }
}