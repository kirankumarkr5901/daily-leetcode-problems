class Solution {

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        if(isPalindrome(s)) return true;

        int left = 0;
        int right = s.length()-1;
        while(s.charAt(left) == s.charAt(right)) {
            left++;
            right--;
        }
        String deleteLeft = new StringBuilder(s).deleteCharAt(left).toString();
        String deleteRight = new StringBuilder(s).deleteCharAt(right).toString();
        return isPalindrome(deleteLeft) || isPalindrome(deleteRight);
    }
}