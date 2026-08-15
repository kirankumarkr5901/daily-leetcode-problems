class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int nonZero = 0;
        int fullXOR = 0;
        for(int num: nums) {
            if(num != 0) {
                nonZero++;
            }
            fullXOR ^= num;
        }

        if(nonZero == 0) return 0;
        if(fullXOR != 0) return n;

        return n-1;

    }
}