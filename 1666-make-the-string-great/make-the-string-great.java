class Solution {
    private boolean isSame(char a, char b) {
        if(Character.toLowerCase(a) == Character.toLowerCase(b)) {
            return Character.isUpperCase(a) && Character.isLowerCase(b) || Character.isUpperCase(b) && Character.isLowerCase(a);
        }
        return false;
    }
    public String makeGood(String s) {
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(stack.isEmpty() || !isSame(c, stack.peek()))
                stack.push(c);
            else 
                stack.pop();
        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty())
            ans.insert(0, stack.pop());
        return ans.toString();
    }
}