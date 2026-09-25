import java.util.*;

class Solution {

    private int idx;

    public List<String> braceExpansionII(String expression) {
        idx = 0;
        Set<String> result = parse(expression);
        return new ArrayList<>(result);
    }

    private Set<String> parse(String s) {
        Set<String> union = new TreeSet<>();
        Set<String> curr = new TreeSet<>();
        curr.add("");

        while (idx < s.length() && s.charAt(idx) != '}') {
            char ch = s.charAt(idx);

            if (ch == ',') {
                union.addAll(curr);
                curr = new TreeSet<>();
                curr.add("");
                idx++;
            } else {
                Set<String> next;

                if (ch == '{') {
                    idx++; // skip {
                    next = parse(s);
                    idx++; // skip }
                } else {
                    next = new TreeSet<>();
                    next.add(String.valueOf(ch));
                    idx++;
                }

                curr = combine(curr, next);
            }
        }

        union.addAll(curr);
        return union;
    }

    private Set<String> combine(Set<String> a, Set<String> b) {
        Set<String> res = new TreeSet<>();

        for (String s1 : a) {
            for (String s2 : b) {
                res.add(s1 + s2);
            }
        }

        return res;
    }
}