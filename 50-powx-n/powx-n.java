class Solution {
    public double myPow(double x, int n) {
        long power = n;

        if (power < 0) {
            return 1.0 / pow(x, -power);
        }

        return pow(x, power);
    }

    private double pow(double x, long n) {
        if (n == 0)
            return 1.0;

        double half = pow(x, n / 2);

        if (n % 2 == 0)
            return half * half;

        return half * half * x;
    }
}