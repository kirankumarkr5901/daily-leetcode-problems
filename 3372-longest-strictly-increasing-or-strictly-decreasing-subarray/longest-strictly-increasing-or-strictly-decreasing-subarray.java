class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int ans = 1;
        int left = 0;
        for(int right = 1;right < nums.length;right++) {
            if(nums[right-1] >= nums[right]) {
                ans = Math.max(ans, right - left);
                left = right;
            }
        }
        ans = Math.max(ans, nums.length - left);
        left = 0;
        for(int right = 1;right < nums.length;right++) {
            if(nums[right-1] <= nums[right]) {
                ans = Math.max(ans, right - left);
                left = right;
            }
        }
        ans = Math.max(ans, nums.length - left);
        return ans;
    }
}