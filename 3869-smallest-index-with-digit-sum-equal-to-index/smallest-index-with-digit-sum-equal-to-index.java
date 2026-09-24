class Solution {
    private int getDigitSum(int n) {
        int sum = 0;
        while(n > 0) {
            sum += n%10;
            n /= 10;
        }
        return sum;
    }
    public int smallestIndex(int[] nums) {
        for(int i = 0;i<nums.length;i++) {
            if(i == getDigitSum(nums[i])) return i;
        }
        return -1;
    }
}