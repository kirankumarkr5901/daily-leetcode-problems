public class Solution {
    public String smallestNumber(String num, long t) {
        // Step 1: Count required prime factors for t
        long tempT = t;
        int[] targetFactors = new int[10]; // index 2, 3, 5, 7
        int[] primes = {2, 3, 5, 7};
        for (int p : primes) {
            while (tempT % p == 0) {
                targetFactors[p]++;
                tempT /= p;
            }
        }
        if (tempT > 1) {
            return "-1"; // Contains prime factors other than 2, 3, 5, or 7
        }

        int n = num.length();
        int[][] prefixFactors = new int[n + 1][10];
        int firstZero = -1;

        // Step 2: Compute prefix factor accumulation and find any 0 digits
        for (int i = 0; i < n; i++) {
            int digit = num.charAt(i) - '0';
            System.arraycopy(prefixFactors[i], 0, prefixFactors[i + 1], 0, 10);
            if (digit == 0) {
                if (firstZero == -1) firstZero = i;
            } else {
                for (int p : primes) {
                    int d = digit;
                    while (d % p == 0) {
                        prefixFactors[i + 1][p]++;
                        d /= p;
                    }
                }
            }
        }

        // Check if the original number satisfies the condition
        if (firstZero == -1 && isSatisfied(prefixFactors[n], targetFactors)) {
            return num;
        }

        // Limit our prefix matching up to the first occurrence of '0'
        int limit = (firstZero == -1) ? n - 1 : firstZero;

        // Step 3: Backtrack from right to left to find the pivot point to increment
        for (int i = limit; i >= 0; i--) {
            int currentDigit = num.charAt(i) - '0';
            for (int d = currentDigit + 1; d <= 9; d++) {
                int[] currentFactors = new int[10];
                System.arraycopy(prefixFactors[i], 0, currentFactors, 0, 10);
                
                // Add the factors of the newly placed digit 'd'
                int tempD = d;
                for (int p : primes) {
                    while (tempD % p == 0) {
                        currentFactors[p]++;
                        tempD /= p;
                    }
                }

                int remLength = n - 1 - i;
                if (canFormSuffix(currentFactors, targetFactors, remLength)) {
                    // Reconstruct the valid string
                    StringBuilder sb = new StringBuilder();
                    sb.append(num, 0, i).append(d);
                    sb.append(generateSmallestSuffix(currentFactors, targetFactors, remLength));
                    return sb.toString();
                }
            }
        }

        // Step 4: If no number of length 'n' works, construct the smallest valid longer number
        int minRequiredLen = getMinSuffixLength(new int[10], targetFactors);
        int newLen = Math.max(n + 1, minRequiredLen);
        
        StringBuilder sb = new StringBuilder();
        String suffix = generateSmallestSuffix(new int[10], targetFactors, newLen);
        return suffix;
    }

    private boolean isSatisfied(int[] current, int[] target) {
        return current[2] >= target[2] && current[3] >= target[3] && 
               current[5] >= target[5] && current[7] >= target[7];
    }

    // Checks if the remaining factors can fit into the remaining available digit slots
    private boolean canFormSuffix(int[] current, int[] target, int remLength) {
        int req2 = Math.max(0, target[2] - current[2]);
        int req3 = Math.max(0, target[3] - current[3]);
        int req5 = Math.max(0, target[5] - current[5]);
        int req7 = Math.max(0, target[7] - current[7]);

        // Maximize compression into 8s, 9s, 6s, 4s to minimize length
        int count8 = req2 / 3;
        req2 %= 3;
        int count9 = req3 / 2;
        req3 %= 2;
        
        int count6 = 0;
        if (req2 > 0 && req3 > 0) {
            count6 = 1;
            req2--;
            req3--;
        }
        
        int count4 = req2 / 2;
        req2 %= 2;
        
        int remDigits = count8 + count9 + count6 + count4 + req2 + req3 + req5 + req7;
        return remDigits <= remLength;
    }

    private int getMinSuffixLength(int[] current, int[] target) {
        int req2 = Math.max(0, target[2] - current[2]);
        int req3 = Math.max(0, target[3] - current[3]);
        int req5 = Math.max(0, target[5] - current[5]);
        int req7 = Math.max(0, target[7] - current[7]);

        int count8 = req2 / 3; req2 %= 3;
        int count9 = req3 / 2; req3 %= 2;
        int count6 = 0;
        if (req2 > 0 && req3 > 0) { count6 = 1; req2--; req3--; }
        int count4 = req2 / 2; req2 %= 2;

        return count8 + count9 + count6 + count4 + req2 + req3 + req5 + req7;
    }

    // Greedily builds the lexicographically smallest digits to satisfy constraints
    private String generateSmallestSuffix(int[] current, int[] target, int remLength) {
        int req2 = Math.max(0, target[2] - current[2]);
        int req3 = Math.max(0, target[3] - current[3]);
        int req5 = Math.max(0, target[5] - current[5]);
        int req7 = Math.max(0, target[7] - current[7]);

        int count8 = req2 / 3; req2 %= 3;
        int count9 = req3 / 2; req3 %= 2;
        int count6 = 0;
        if (req2 > 0 && req3 > 0) { count6 = 1; req2--; req3--; }
        int count4 = req2 / 2; req2 %= 2;

        StringBuilder suffix = new StringBuilder();
        for (int i = 0; i < req7; i++) suffix.append('7');
        for (int i = 0; i < req5; i++) suffix.append('5');
        for (int i = 0; i < count9; i++) suffix.append('9');
        for (int i = 0; i < count8; i++) suffix.append('8');
        for (int i = 0; i < count6; i++) suffix.append('6');
        for (int i = 0; i < count4; i++) suffix.append('4');
        if (req3 > 0) suffix.append('3');
        if (req2 > 0) suffix.append('2');

        // Pad with '1's up to the exact target length
        while (suffix.length() < remLength) {
            suffix.append('1');
        }

        // Sort characters to make sure the suffix yields the smallest numerical value
        char[] chars = suffix.toString().toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}