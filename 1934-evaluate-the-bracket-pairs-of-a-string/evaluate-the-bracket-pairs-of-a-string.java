class Solution {
    public String evaluate(String s, List<List<String>> knowledge) {
        StringBuilder answer = new StringBuilder();
        Map<String, String> map = new HashMap();

        for(List<String> pair: knowledge)
            map.put(pair.get(0), pair.get(1));
        
        int left = 0;
        int n = s.length();
        for(int right = 0;right<n;right++) {
            char c = s.charAt(right);
            if(c == '(') {
                right++;
                left = right;
                while(right < n && s.charAt(right) != ')') {
                    right++;
                }
                String key = s.substring(left, right);
                if(map.containsKey(key)) {
                    answer.append(map.get(key));
                } else {
                    answer.append("?");
                }
            } else {
                answer.append(String.valueOf(s.charAt(right)));
            }
        }
        return answer.toString();
    }
}