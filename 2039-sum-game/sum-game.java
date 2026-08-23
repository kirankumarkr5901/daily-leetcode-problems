class Solution {
    public boolean sumGame(String num) {
        int leftQ = 0;
        int rightQ = 0;
        int leftPreSum = 0;
        int rightPreSum = 0;
        int left = 0;
        int right = num.length() - 1;
        while(left < right) {
            if(num.charAt(left) == '?') {
                leftQ++;
            } else {
                leftPreSum += (num.charAt(left) - '0');
            }
            left++;
            if(num.charAt(right) == '?') {
                rightQ++;
            } else {
                rightPreSum += (num.charAt(right) - '0');
            }
            right--;
        }
        if(((leftQ+rightQ) & 1) == 1) {
            return true;
        }
        if(leftQ == rightQ) {
            return leftPreSum != rightPreSum;
        }
        int leftSum = (2 * leftPreSum) + (9 * leftQ);
        int rightSum = (2 * rightPreSum) + (9 * rightQ);
        return leftSum != rightSum;
    }
}