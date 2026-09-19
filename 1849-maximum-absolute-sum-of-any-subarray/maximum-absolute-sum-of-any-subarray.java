class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int answer = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0;i<nums.length;i++) {
            sum += nums[i];
            answer = Math.max(sum, answer);
            if(sum < 0) {
                sum = 0;
            }
            nums[i] *= -1;
        }
        sum = 0;
        for(int num: nums) {
            sum += num;
            answer = Math.max(sum, answer);
            if(sum < 0) {
                sum = 0;
            }
        }
        return answer;
    }
}