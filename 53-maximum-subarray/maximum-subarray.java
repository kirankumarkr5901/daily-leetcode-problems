class Solution {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int answer = Integer.MIN_VALUE;
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