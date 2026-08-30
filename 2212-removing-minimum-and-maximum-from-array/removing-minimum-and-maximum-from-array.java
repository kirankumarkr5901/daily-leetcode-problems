class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        if(n == 1) {
            return 1;
        } else if(n == 2 || n == 3) {
            return 2;
        }
        int maxIndex = 0;
        int minIndex = 0;
        for(int i = 1;i<n;i++) {
            if(nums[maxIndex] < nums[i]) {
                maxIndex = i;
            }
            if(nums[minIndex] > nums[i]) {
                minIndex = i;
            }
        }
        int left = Math.max(maxIndex + 1, minIndex + 1);
        int right = Math.max(n - maxIndex, n - minIndex);
        int bothLeft = Math.min(maxIndex + 1, minIndex +1);
        int bothRight = Math.min(n - maxIndex, n - minIndex);
        int singleSide = Math.min(left, right);
        int bothSide = bothLeft + bothRight;
        return Math.min(singleSide, bothSide);
    }
}