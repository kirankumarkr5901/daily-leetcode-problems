class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] nums = new int[cols];

        for(int i = 0;i<rows;i++) {
            for(int j = 0;j<cols;j++) {
                nums[j] = matrix[i][j] == '0' ? 0 : nums[j]+1;
            }
            maxArea = Math.max(maxArea, getArea(nums));
        }
        return maxArea;
    }

    private int getArea(int[] nums) {
        int maxArea = 0;
        Stack<Integer> stack = new Stack();
        int n = nums.length;

        for(int i = 0;i <= n;i++) {
            int currentH = i == n ? 0 : nums[i];

            while(!stack.isEmpty() && nums[stack.peek()] >= currentH) {
                int h = nums[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.add(i);
        }
        return maxArea;
    }
}