class Solution {
    private int getProductOfDigits(int n) {
        int product = 1;
        if(n == 0) {
            return n;
        }
        while(n > 0) {
            int reminder = n % 10;
            product *= reminder;
            n /= 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        int number = n;
        for(int i = 0;i<=t;i++, number++) {
            int product = getProductOfDigits(number);
            if(product % t == 0) {
                break;
            }
        }
        return number;
    }
}