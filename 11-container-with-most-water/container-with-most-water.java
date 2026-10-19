class Solution {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;

        int ans = 0;
        while(start < end) {
            int curr = Math.min(height[start], height[end]) * (end - start);
            ans = Math.max(curr, ans);
            if(height[start] < height[end])
                start++;
            else end--;
        }
        return ans;
    }
}