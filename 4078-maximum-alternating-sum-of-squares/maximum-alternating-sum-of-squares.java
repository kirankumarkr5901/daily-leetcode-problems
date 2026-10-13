class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        for(int i = 0;i<n;i++)
            nums[i] *= nums[i];

        Arrays.sort(nums);
        long ans = 0;
        int half = n/2;
        for(int i = half;i<n;i++) {
            ans += (long)nums[i];
        }
        for(int i = 0;i<half;i++) {
            ans -= (long)nums[i];
        }
        return ans;
    }
}