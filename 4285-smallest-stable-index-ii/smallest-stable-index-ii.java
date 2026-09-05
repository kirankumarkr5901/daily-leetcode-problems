class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] min = new int[n];
        min[n-1] = nums[n-1];

        for(int i = n-2;i>=0;i--) {
            min[i] = Math.min(min[i+1], nums[i]);
        }

        int currMax = nums[0];
        for(int i = 0;i<n;i++) {
            currMax = Math.max(currMax, nums[i]);
            int diff = currMax - min[i];
            if(diff <= k) return i;
        }
        return -1;
    }
}