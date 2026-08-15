class Solution {
    public boolean isPowerOfTwo(int n) {
        // int numberOfOne = 0;
        // while(n > 0) {
        //     if((n&1) == 1) {
        //         numberOfOne++;
        //     }
        //     n = n >> 1;
        // }
        // // core logic is 2^x will always have single set bit
        // return numberOfOne == 1;

        // Efficient
        return n > 0 && (n & (--n)) == 0;
    }
}