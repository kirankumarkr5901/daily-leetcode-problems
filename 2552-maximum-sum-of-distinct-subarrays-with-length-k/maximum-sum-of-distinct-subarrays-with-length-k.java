class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet();
        int start = 0;
        int end = 0;
        long sum = 0;
        long answer  = 0;
        while(end < nums.length) {
            while(set.contains(nums[end])) {
                sum -= (long)nums[start];
                set.remove(nums[start]);
                start++;
            }
            set.add(nums[end]);
            sum += (long)nums[end];
            if(set.size() == k) {
                answer = Math.max(answer, sum);
            }

            while(set.size() >= k) {
                sum -= (long)nums[start];
                set.remove(nums[start]);
                start++;
            }
            end++;
        }
        return answer;
    }
}