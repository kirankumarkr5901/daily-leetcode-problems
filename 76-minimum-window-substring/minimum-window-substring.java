class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length() || t.isEmpty()) return "";

        Map<Character, Integer> need = new HashMap();
        for(char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0)+1);
        }
        Map<Character, Integer> window = new HashMap();
        int start = 0;
        int have = 0;
        int required = need.size();
        int bestLen = Integer.MAX_VALUE;
        int bestStart = 0;
        for(int end = 0;end < s.length();end++) {
            char c = s.charAt(end);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(need.containsKey(c) && need.get(c).intValue() == window.get(c).intValue()) {
                have++;
            }

            while(have == required) {
                if((end - start + 1) < bestLen) {
                    bestLen = end - start + 1;
                    bestStart = start;
                }

                char sc = s.charAt(start);
                window.put(sc, window.get(sc)-1);
                if(need.containsKey(sc) && window.get(sc) < need.get(sc)) {
                    have--;
                }
                start++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}