class Solution {
    private void rotatePart(int[] nums, int left, int right) {
        while(left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        rotatePart(nums, 0, n-1);
        rotatePart(nums, 0, k-1);
        rotatePart(nums, k, n-1);
    }
}