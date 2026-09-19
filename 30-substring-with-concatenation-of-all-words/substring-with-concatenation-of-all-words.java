class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> need = new HashMap<>();
        for (String word : words) {
            need.put(word, need.getOrDefault(word, 0) + 1);
        }

        int required = need.size();
        int wordLen = words[0].length();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> window = new HashMap<>();
            int have = 0;
            int start = i;

            for (int end = i; end + wordLen <= s.length(); end += wordLen) {
                String word = s.substring(end, end + wordLen);

                if (!need.containsKey(word)) {
                    window.clear();
                    have = 0;
                    start = end + wordLen;
                    continue;
                }

                window.put(word, window.getOrDefault(word, 0) + 1);
                if (window.get(word).intValue() == need.get(word).intValue()) {
                    have++;
                }

                while (window.get(word) > need.get(word)) {
                    String startWord = s.substring(start, start + wordLen);
                    if (window.get(startWord).intValue() == need.get(startWord).intValue()) have--;
                    window.put(startWord, window.get(startWord) - 1);
                    start += wordLen;
                }

                if (have == required) {
                    answer.add(start);
                    String startWord = s.substring(start, start + wordLen);
                    if (window.get(startWord).intValue() == need.get(startWord).intValue()) have--;
                    window.put(startWord, window.get(startWord) - 1);
                    start += wordLen;
                }
            }
        }
        return answer;
    }
}