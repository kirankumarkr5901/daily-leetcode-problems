class Solution {

    int n;
    int maxLength;
    Set<String> set;
    private void solve(String s, StringBuilder sb, int index, int count, int currentRemoval) {
        if(count < 0 || currentRemoval > (n - maxLength)) {
            return;
        }

        if(index == n) {
            if(count == 0) {
                if(maxLength < sb.length()) {
                    set.clear();
                    set.add(sb.toString());
                    maxLength = sb.length();
                } else if(maxLength == sb.length()) {
                    set.add(sb.toString());
                }
            }
            return;
        }

        char c = s.charAt(index);
        if(c == '(' || c == ')') {
            sb.append(c);
            if(c == '(') {
                solve(s, sb, index+1, count + 1, currentRemoval);
            } else {
                solve(s, sb, index+1, count - 1, currentRemoval);
            }
            sb.deleteCharAt(sb.length()-1);
            solve(s, sb, index+1, count, currentRemoval+1);
        } else {
            sb.append(c);
            solve(s, sb, index+1, count, currentRemoval);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public List<String> removeInvalidParentheses(String s) {
        n = s.length();
        maxLength = 0;
        set = new HashSet();
        solve(s, new StringBuilder(), 0, 0, 0);
        return new ArrayList(set);
    }
}