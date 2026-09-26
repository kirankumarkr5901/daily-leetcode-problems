class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack();
        int maxArea = 0;
        int n = heights.length;

        for(int i = 0;i<=n;i++) {
            int currentH = i == n ? 0 : heights[i];

            if(stack.isEmpty() || heights[stack.peek()] <= currentH)
                stack.add(i);
            else {
                while(!stack.isEmpty() && heights[stack.peek()] > currentH) {
                    int h = heights[stack.pop()];
                    int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                    maxArea = Math.max(maxArea, h * w);
                }
                stack.add(i);
            }
        }
        return maxArea;
    }
}