class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if((num * 9) < sum) return "";
        int rem = sum % 9;
        int nines = sum / 9;
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i<nines;i++) {
            sb.append('9');
        }
        if(rem > 0) {
            sb.append(String.valueOf(rem));
        }
        for(int i = sb.length();i<num;i++) {
            sb.append('0');
        }
        return sb.toString();
    }
}