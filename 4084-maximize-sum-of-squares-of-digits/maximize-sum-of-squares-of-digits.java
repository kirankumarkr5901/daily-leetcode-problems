class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num*9) return "";
        
        StringBuilder ans =  new StringBuilder();
        ans.append("");
        
        for(int i = 0; i < num; i++){

            // 99 3
            if((sum - 9) >= 0){
                ans.append('9');
                sum -= 9;
            }
            else if((sum - 8) >= 0){
                ans.append('8');
                sum -= 8;
            }
            else if((sum - 7) >= 0){
                ans.append('7');
                sum -= 7;
            }
            else if((sum - 6) >= 0){
                ans.append('6');
                sum -= 6;
            }
            else if((sum - 5) >= 0){
                ans.append('5');
                sum -= 5;
            }
            else if((sum - 4) >= 0){
                ans.append('4');
                sum -= 4;
            }
            else if((sum - 3) >= 0){
                ans.append('3');
                sum -= 3;
            }
            else if((sum - 2) >= 0){
                ans.append('2');
                sum -= 2;
            }
            else if((sum - 1) >= 0){
                ans.append('1');
                sum -= 1;
            }
            
        }
        for(int i = ans.length();i < num; i++){
            ans.append("0");
        }
        return ans.toString();
    }
}

// class Solution {
//     String ans = "";
//     // private int calculateSum(int num) {
//     //     int sum = 0;
//     //     while(num > 0) {
//     //         sum += num%10;
//     //         num /= 10;
//     //     }
//     //     return sum;
//     // }
//     private boolean solve(int num, int sum, StringBuilder sb, int len, int currSum) {
//         if(currSum > sum) {
//             return false;
//         }
//         if(len == num) {
//             if(currSum == sum) {
//                 ans = sb.toString();
//                 return true;
//             }
//             return false;
//         }
//         if((sum - currSum) > 9) {
//             for(int i = 9;i>=0;i--) {
//                 sb.append(String.valueOf(i));
//                 if(solve(num, sum, sb, len+1, currSum+i)) return true;
//                 sb.deleteCharAt(sb.length()-1);
//             }
//         } else {
//             int rem = sum - currSum;
//             sb.append(String.valueOf(rem));
//             if(solve(num, sum, sb, len+1, currSum+rem)) return true;
//             sb.deleteCharAt(sb.length()-1);
//         }
//         return false;
//     }
//     public String maxSumOfSquares(int num, int sum) {
//         if((num * 9) < sum) {
//             return "";
//         }
//         return solve(num, sum, new StringBuilder(), 0, 0) ? String.valueOf(ans) : "";
//     }
// }