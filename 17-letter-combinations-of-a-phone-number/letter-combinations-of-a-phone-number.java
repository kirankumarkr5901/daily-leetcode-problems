class Solution {
    String[] chars = {"abc", "def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    private void addStrings(String digits, List<String> ans, String currentString, int index) {
        int n = digits.length();
        int digit = digits.charAt(index) - '0';
        String digitString = chars[digit-2];
        if(index == n-1) {
            for(char c: digitString.toCharArray()) {
                ans.add(currentString + String.valueOf(c));
            }
            return;
        }
        for(char c: digitString.toCharArray()) {
            addStrings(digits, ans, currentString + String.valueOf(c), index+1);
        }
    }

    public List<String> letterCombinations(String digits) {
        int n = digits.length();
        List<String> ans = new ArrayList();
        addStrings(digits, ans, "", 0);
        return ans;
    }
}