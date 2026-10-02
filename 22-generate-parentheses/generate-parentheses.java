class Solution {
    List<String> list;

    private void generate(StringBuilder sb, int n, int open, int close) {
        if(open == close && close == n) {
            list.add(sb.toString());
            return;
        }
        if(open < n) {
            sb.append("(");
            generate(sb, n, open+1, close);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close < open) {
            sb.append(")");
            generate(sb, n, open, close+1);
            sb.deleteCharAt(sb.length()-1);
        }
        return;
    }

    public List<String> generateParenthesis(int n) {
        list = new ArrayList();
        StringBuilder sb = new StringBuilder();
        generate(sb, n, 0, 0);
        return list;
    }
}