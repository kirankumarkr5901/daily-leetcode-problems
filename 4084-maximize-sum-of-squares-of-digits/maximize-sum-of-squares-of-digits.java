class Solution {
    String ans = "";
    // private int calculateSum(int num) {
    //     int sum = 0;
    //     while(num > 0) {
    //         sum += num%10;
    //         num /= 10;
    //     }
    //     return sum;
    // }
    private boolean solve(int num, int sum, StringBuilder sb, int len, int currSum) {
        if(currSum > sum) {
            return false;
        }
        if(len == num) {
            if(currSum == sum) {
                ans = sb.toString();
                return true;
            }
            return false;
        }
        if((sum - currSum) > 9) {
            for(int i = 9;i>=0;i--) {
                sb.append(String.valueOf(i));
                if(solve(num, sum, sb, len+1, currSum+i)) return true;
                sb.deleteCharAt(sb.length()-1);
            }
        } else {
            int rem = sum - currSum;
            sb.append(String.valueOf(rem));
            if(solve(num, sum, sb, len+1, currSum+rem)) return true;
            sb.deleteCharAt(sb.length()-1);
        }
        return false;
    }
    public String maxSumOfSquares(int num, int sum) {
        if((num * 9) < sum) {
            return "";
        }
        return solve(num, sum, new StringBuilder(), 0, 0) ? String.valueOf(ans) : "";
    }
}