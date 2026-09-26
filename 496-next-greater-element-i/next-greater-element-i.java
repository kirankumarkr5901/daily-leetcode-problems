class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int max = nums2[0];
        for(int num: nums2)
            max = Math.max(max, num);

        int[] next = new int[max+1];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack();

        for(int i = nums2.length-1;i>=0;i--) {
            int num = nums2[i];
            while(!stack.isEmpty() && stack.peek() <= num)
                stack.pop();

            if(!stack.isEmpty())
                next[num] = stack.peek();
            stack.add(num);
        }

        for(int i = 0;i<nums1.length;i++)
            nums1[i] = next[nums1[i]];
        return nums1;
    }
}