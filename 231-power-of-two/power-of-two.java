class Solution {
    public boolean isPowerOfTwo(int n) {
        int numberOfOne = 0;
        while(n > 0) {
            if((n&1) == 1) {
                numberOfOne++;
            }
            n = n >> 1;
        }
        return numberOfOne == 1;
    }
}