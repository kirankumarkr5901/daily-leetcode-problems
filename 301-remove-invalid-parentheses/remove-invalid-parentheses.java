class Solution {
    Set<String> set;
    int n;
    int curr;
    private boolean isValid(StringBuilder sb) {
        Stack<Character> st = new Stack();
        for(char c: sb.toString().toCharArray()) {
            if(c == '(' || c == ')') {
                if(c == '(')
                    st.push(c);
                else if(st.isEmpty()) {
                    return false;
                } else {
                    st.pop();
                }
            }
        }
        return st.isEmpty();
    }
    private void solve(StringBuilder sb, int index) {
        if(index == sb.length()) {
            if(isValid(sb)) {
                int diff = n - sb.length();
                if(diff == curr) {
                    set.add(sb.toString());
                } else if(diff < curr) {
                    curr = diff;
                    set.clear();
                    set.add(sb.toString());
                }
            }
            return;
        }

        char c = sb.charAt(index);
        if(c == '(' || c == ')') {
            solve(sb, index+1);
            sb.deleteCharAt(index);
            solve(sb, index);
            sb.insert(index, c);
        } else {
            solve(sb, index+1);
        }
    }
    public List<String> removeInvalidParentheses(String s) {
        set = new HashSet();
        n = s.length();
        curr = n+1;
        StringBuilder sb = new StringBuilder(s);
        solve(sb, 0);
        return new ArrayList(set);
    }
}