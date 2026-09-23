class Solution {
    public int minOperations(int[] nums, int x) {
        int total = 0;
        for(int num: nums) total += num;
        int n = nums.length;
        int targetSum = total - x;
        if(targetSum < 0) return -1;
        if(targetSum == 0) return n;

        int left = 0;
        int curr = 0;
        int maxLen = -1;
        for(int right = 0;right<n;right++) {
            curr += nums[right];
            while(curr > targetSum) {
                curr -= nums[left];
                left++;
            }
            if(curr == targetSum) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }
        return maxLen == -1 ? -1 : n - maxLen;
    }
}