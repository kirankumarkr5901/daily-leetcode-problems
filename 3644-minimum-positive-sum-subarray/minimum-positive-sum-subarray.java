class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int size = nums.size();
        for(int left = l;left<=r;left++) {
            int sum = 0;
            for(int i = 0;i<left-1;i++) {
                sum += nums.get(i);
            }
            for(int i = left-1, j = 0;i<size;i++, j++) {
                sum += nums.get(i);
                if(sum > 0) {
                    ans = Math.min(sum, ans);
                }
                sum -= nums.get(j);
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}